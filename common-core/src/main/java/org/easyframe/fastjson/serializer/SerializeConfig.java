/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easyframe.fastjson.serializer;

import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

import jef.tools.Assert;

import org.easyframe.fastjson.JSON;
import org.easyframe.fastjson.JSONException;
import org.easyframe.fastjson.annotation.JSONType;
import org.easyframe.fastjson.util.ASMUtils;
import org.easyframe.fastjson.util.IdentityHashMap;

/**
 * circular references detect
 * 
 * @author wenshao<szujobs@hotmail.com>
 */
public class SerializeConfig extends IdentityHashMap<Type, ObjectSerializer> {
	private final static SerializeConfig globalInstance = new SerializeConfig();

	private boolean asm = !ASMUtils.isAndroid();

	private final ASMSerializerFactory asmFactory = new ASMSerializerFactory();
	
	private final SerializeConfig parent;

	private String typeKey = JSON.DEFAULT_TYPE_KEY;
	
	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

	public final ObjectSerializer createASMSerializer(Class<?> clazz)
			throws Exception {
		return asmFactory.createJavaBeanSerializer(clazz);
	}
	
	public final ObjectSerializer createASMSerializer(Class<?> clazz,Map<String,String> alias)
			throws Exception {
		return asmFactory.createJavaBeanSerializer(clazz,alias);
	}
	

	public ObjectSerializer createJavaBeanSerializer(Class<?> clazz) {
		JSONType annotation = clazz.getAnnotation(JSONType.class);
		if(annotation!=null && annotation.serializer()!=Void.class){
			return getCustomSerializer(annotation.serializer());
		}
		
		if (!Modifier.isPublic(clazz.getModifiers())) {
			return new JavaBeanSerializer(clazz);
		}
		boolean asm = this.asm;
		if (asm && asmFactory.isExternalClass(clazz)
				|| clazz == Serializable.class || clazz == Object.class) {
			asm = false;
		}
		
		{
			if (annotation != null && annotation.asm() == false) {
				asm = false;
			}
			
		}

		if (asm) {
			try {
				return createASMSerializer(clazz);
			} catch (ClassCastException e) {
				// skip
				return new JavaBeanSerializer(clazz);
			} catch (Throwable e) {
				throw new JSONException("create asm serializer error, class "
						+ clazz, e);
			}
		}

		return new JavaBeanSerializer(clazz);
	}

	private ObjectSerializer getCustomSerializer(Class<?> serializer) {
		Method m;
		try{
			m=serializer.getDeclaredMethod("getSerializer"); //try to get singleton instance.
			m.setAccessible(true);
		}catch(NoSuchMethodException e){
			try {
				return (ObjectSerializer) serializer.newInstance();//call empty constructor
			} catch (Exception e1) {
				throw new IllegalStateException(e1);
			}
		}
		try{
			Object o=m.invoke(null);
			Assert.notNull(o);
			return (ObjectSerializer)o;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	public boolean isAsmEnable() {
		return asm;
	}

	public void setAsmEnable(boolean asmEnable) {
		this.asm = asmEnable;
	}

	public final static SerializeConfig getGlobalInstance() {
		return globalInstance;
	}

	public SerializeConfig() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * JEF新增方法，当自定义一个SerializeConfig时，继承另一个SerializeConfig中所有已经生成的序列化器
	 * @param parent
	 */
	public SerializeConfig(SerializeConfig parent) {
		super(128);
		this.parent=parent;
	}
	
	public SerializeConfig(int tableSize) {
		super(tableSize);
		this.parent=null;

		put(Boolean.class, BooleanCodec.instance);
		put(Character.class, CharacterCodec.instance);
		put(Byte.class, ByteSerializer.instance);
		put(Short.class, ShortSerializer.instance);
		put(Integer.class, IntegerCodec.instance);
		put(Long.class, LongCodec.instance);
		put(Float.class, FloatCodec.instance);
		put(Double.class, DoubleSerializer.instance);
		put(BigDecimal.class, BigDecimalCodec.instance);
		put(BigInteger.class, BigIntegerCodec.instance);
		put(String.class, StringCodec.instance);
		put(byte[].class, ByteArraySerializer.instance);
		put(short[].class, ShortArraySerializer.instance);
		put(int[].class, IntArraySerializer.instance);
		put(long[].class, LongArraySerializer.instance);
		put(float[].class, FloatArraySerializer.instance);
		put(double[].class, DoubleArraySerializer.instance);
		put(boolean[].class, BooleanArraySerializer.instance);
		put(char[].class, CharArraySerializer.instance);
		put(Object[].class, ObjectArraySerializer.instance);
		put(Class.class, ClassSerializer.instance);

		put(SimpleDateFormat.class, DateFormatSerializer.instance);
		put(Locale.class, LocaleCodec.instance);
		put(Currency.class, CurrencyCodec.instance);
		put(TimeZone.class, TimeZoneCodec.instance);
		put(UUID.class, UUIDCodec.instance);
		put(InetAddress.class, InetAddressCodec.instance);
		put(Inet4Address.class, InetAddressCodec.instance);
		put(Inet6Address.class, InetAddressCodec.instance);
		put(InetSocketAddress.class, InetSocketAddressCodec.instance);
		put(File.class, FileCodec.instance);
		put(URI.class, URICodec.instance);
		put(URL.class, URLCodec.instance);
		put(Appendable.class, AppendableSerializer.instance);
		put(StringBuffer.class, AppendableSerializer.instance);
		put(StringBuilder.class, AppendableSerializer.instance);
		put(Pattern.class, PatternCodec.instance);
		put(Charset.class, CharsetCodec.instance);

		// atomic
		put(AtomicBoolean.class, AtomicBooleanSerializer.instance);
		put(AtomicInteger.class, AtomicIntegerSerializer.instance);
		put(AtomicLong.class, AtomicLongSerializer.instance);
		put(AtomicReference.class, ReferenceCodec.instance);
		put(AtomicIntegerArray.class, AtomicIntegerArrayCodec.instance);
		put(AtomicLongArray.class, AtomicLongArrayCodec.instance);
		
		put(WeakReference.class, ReferenceCodec.instance);
		put(SoftReference.class, ReferenceCodec.instance);

		// awt
		try {
			put(Class.forName("java.awt.Color"), ColorCodec.instance);
			put(Class.forName("java.awt.Font"), FontCodec.instance);
			put(Class.forName("java.awt.Point"), PointCodec.instance);
			put(Class.forName("java.awt.Rectangle"),
					RectangleCodec.instance);
		} catch (Throwable e) {
			// skip
		}

	}

	public boolean hasType(Type type) {
		return get(type)!=null;
	}
	
	public void putHierarchy(Class clz,ObjectSerializer s){
		if(typeCodecs==null){
			typeCodecs=new HashMap<Class,ObjectSerializer>();
		}
		typeCodecs.put(clz, s);
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public ObjectSerializer find(Class<?> clazz) {
		ObjectSerializer s=this.get(clazz);
		if(s==null && parent!=null){
			s=parent.find(clazz);
		}
		return s;
	}
	
	
	Map<Class,ObjectSerializer> typeCodecs;
}
