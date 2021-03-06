package jef.orm.postgresql.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import jef.codegen.support.NotModified;
import jef.database.DataObject;
/**
 * This class was generated by EasyFrame according to the table in database.
 * You need to modify the type of primary key field, to the strategy your own.
 */
@NotModified
@Entity
@Table(name="test_columntypes_db2entity")
public class TestColumntypesDb2entity82 extends DataObject{


	@Column(name="smallintfield",precision=5,columnDefinition="NUMBER",nullable=false)
	private int smallintfield;

	@Column(name="int2field",precision=5,columnDefinition="NUMBER")
	private Integer int2field;

	@Column(name="intfield2",precision=10,columnDefinition="NUMBER")
	private Long intfield2;

	@Column(name="bigintfield",precision=19,columnDefinition="NUMBER")
	private Long bigintfield;

	@Column(name="decimalfield",scale=4,precision=131089,columnDefinition="NUMBER")
	private Double decimalfield;

	@Column(name="numericfield",scale=4,precision=131089,columnDefinition="NUMBER")
	private Double numericfield;

	@Column(name="numericfield2",scale=2,precision=5,columnDefinition="NUMBER")
	private Float numericfield2;

	@Column(name="realfield",scale=8,precision=8,columnDefinition="NUMBER")
	private Float realfield;

	@Column(name="floatfield",scale=8,precision=8,columnDefinition="NUMBER",nullable=false)
	private Float floatfield;

	@Column(name="doublefield",scale=17,precision=17,columnDefinition="NUMBER",nullable=false)
	private Double doublefield;

	@Column(name="doublefield2",scale=17,precision=17,columnDefinition="NUMBER")
	private Double doublefield2;

	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="serialfield",precision=10,columnDefinition="NUMBER",nullable=false)
	private int serialfield;

	@Column(name="serialfield2",precision=19,columnDefinition="NUMBER",nullable=false)
	private long serialfield2;

	@Column(name="moneyfield",columnDefinition="Varchar",length=2147483647)
	private String moneyfield;

	@Column(name="varcharfield1",columnDefinition="Varchar",length=255)
	private String varcharfield1;

	@Column(name="varcharfield2",columnDefinition="Varchar",length=2147483647)
	private String varcharfield2;

	@Column(name="charfield1",columnDefinition="Char",length=2)
	private String charfield1;

	@Column(name="charfield2",columnDefinition="Char",length=1)
	private String charfield2;

	@Column(name="varbitfield1",columnDefinition="Varchar",length=63)
	private String varbitfield1;

	@Column(name="varbitfield2",columnDefinition="Varchar",length=2147483647)
	private String varbitfield2;

	@Column(name="bitfield1",columnDefinition="Char",length=8)
	private String bitfield1;

	@Column(name="bitfield2",columnDefinition="Char",length=1)
	private String bitfield2;

	@Column(name="cidrfield",columnDefinition="Varchar",length=2147483647)
	private String cidrfield;

	@Column(name="inetfield",columnDefinition="Varchar",length=2147483647)
	private String inetfield;

	@Column(name="macaddrfield",columnDefinition="Varchar",length=2147483647)
	private String macaddrfield;

	@Column(name="booleanfield1",columnDefinition="Boolean",nullable=false)
	private Boolean booleanfield1;

	@Column(name="booleanfield2",columnDefinition="Boolean")
	private Boolean booleanfield2;

	@Column(name="datefield",columnDefinition="Date")
	private Date datefield;

	@Column(name="timestampfield1",columnDefinition="TimeStamp")
	private Date timestampfield1;

	@Column(name="timestampfield2",columnDefinition="TimeStamp")
	private Date timestampfield2;

	@Column(name="timefield1",columnDefinition="TimeStamp")
	private Date timefield1;

	@Column(name="timefield2",columnDefinition="TimeStamp")
	private Date timefield2;

	@Column(name="intervalfield",columnDefinition="Varchar",length=49)
	private String intervalfield;

	@Lob
	@Column(name="binaryfield",columnDefinition="Blob")
	private byte[] binaryfield;

	@Lob
	@Column(name="textfield",columnDefinition="Clob")
	private String textfield;

	@Column(name="tsvectorfield",columnDefinition="Varchar",length=2147483647)
	private String tsvectorfield;

	@Column(name="tsqueryfield",columnDefinition="Varchar",length=2147483647)
	private String tsqueryfield;

	@Column(name="boxfield",columnDefinition="Varchar",length=2147483647)
	private String boxfield;

	@Column(name="circlefield",columnDefinition="Varchar",length=2147483647)
	private String circlefield;

	@Column(name="linefield",columnDefinition="Varchar",length=2147483647)
	private String linefield;

	@Column(name="lsegfield",columnDefinition="Varchar",length=2147483647)
	private String lsegfield;

	@Column(name="pathfield",columnDefinition="Varchar",length=2147483647)
	private String pathfield;

	@Column(name="pointfield",columnDefinition="Varchar",length=2147483647)
	private String pointfield;

	@Column(name="polygonfield",columnDefinition="Varchar",length=2147483647)
	private String polygonfield;

	public void setSmallintfield(int obj){
		this.smallintfield = obj;
	}

	public int getSmallintfield(){
		return smallintfield;
	}

	public void setInt2field(Integer obj){
		this.int2field = obj;
	}

	public Integer getInt2field(){
		return int2field;
	}

	public void setIntfield2(Long obj){
		this.intfield2 = obj;
	}

	public Long getIntfield2(){
		return intfield2;
	}

	public void setBigintfield(Long obj){
		this.bigintfield = obj;
	}

	public Long getBigintfield(){
		return bigintfield;
	}

	public void setDecimalfield(Double obj){
		this.decimalfield = obj;
	}

	public Double getDecimalfield(){
		return decimalfield;
	}

	public void setNumericfield(Double obj){
		this.numericfield = obj;
	}

	public Double getNumericfield(){
		return numericfield;
	}

	public void setNumericfield2(Float obj){
		this.numericfield2 = obj;
	}

	public Float getNumericfield2(){
		return numericfield2;
	}

	public void setRealfield(Float obj){
		this.realfield = obj;
	}

	public Float getRealfield(){
		return realfield;
	}

	public void setFloatfield(Float obj){
		this.floatfield = obj;
	}

	public Float getFloatfield(){
		return floatfield;
	}

	public void setDoublefield(Double obj){
		this.doublefield = obj;
	}

	public Double getDoublefield(){
		return doublefield;
	}

	public void setDoublefield2(Double obj){
		this.doublefield2 = obj;
	}

	public Double getDoublefield2(){
		return doublefield2;
	}

	public void setSerialfield(int obj){
		this.serialfield = obj;
	}

	public int getSerialfield(){
		return serialfield;
	}

	public void setSerialfield2(long obj){
		this.serialfield2 = obj;
	}

	public long getSerialfield2(){
		return serialfield2;
	}

	public void setMoneyfield(String obj){
		this.moneyfield = obj;
	}

	public String getMoneyfield(){
		return moneyfield;
	}

	public void setVarcharfield1(String obj){
		this.varcharfield1 = obj;
	}

	public String getVarcharfield1(){
		return varcharfield1;
	}

	public void setVarcharfield2(String obj){
		this.varcharfield2 = obj;
	}

	public String getVarcharfield2(){
		return varcharfield2;
	}

	public void setCharfield1(String obj){
		this.charfield1 = obj;
	}

	public String getCharfield1(){
		return charfield1;
	}

	public void setCharfield2(String obj){
		this.charfield2 = obj;
	}

	public String getCharfield2(){
		return charfield2;
	}

	public void setVarbitfield1(String obj){
		this.varbitfield1 = obj;
	}

	public String getVarbitfield1(){
		return varbitfield1;
	}

	public void setVarbitfield2(String obj){
		this.varbitfield2 = obj;
	}

	public String getVarbitfield2(){
		return varbitfield2;
	}

	public void setBitfield1(String obj){
		this.bitfield1 = obj;
	}

	public String getBitfield1(){
		return bitfield1;
	}

	public void setBitfield2(String obj){
		this.bitfield2 = obj;
	}

	public String getBitfield2(){
		return bitfield2;
	}

	public void setCidrfield(String obj){
		this.cidrfield = obj;
	}

	public String getCidrfield(){
		return cidrfield;
	}

	public void setInetfield(String obj){
		this.inetfield = obj;
	}

	public String getInetfield(){
		return inetfield;
	}

	public void setMacaddrfield(String obj){
		this.macaddrfield = obj;
	}

	public String getMacaddrfield(){
		return macaddrfield;
	}

	public void setBooleanfield1(Boolean obj){
		this.booleanfield1 = obj;
	}

	public Boolean isBooleanfield1(){
		return booleanfield1;
	}

	public void setBooleanfield2(Boolean obj){
		this.booleanfield2 = obj;
	}

	public Boolean isBooleanfield2(){
		return booleanfield2;
	}

	public void setDatefield(Date obj){
		this.datefield = obj;
	}

	public Date getDatefield(){
		return datefield;
	}

	public void setTimestampfield1(Date obj){
		this.timestampfield1 = obj;
	}

	public Date getTimestampfield1(){
		return timestampfield1;
	}

	public void setTimestampfield2(Date obj){
		this.timestampfield2 = obj;
	}

	public Date getTimestampfield2(){
		return timestampfield2;
	}

	public void setTimefield1(Date obj){
		this.timefield1 = obj;
	}

	public Date getTimefield1(){
		return timefield1;
	}

	public void setTimefield2(Date obj){
		this.timefield2 = obj;
	}

	public Date getTimefield2(){
		return timefield2;
	}

	public void setIntervalfield(String obj){
		this.intervalfield = obj;
	}

	public String getIntervalfield(){
		return intervalfield;
	}

	public void setBinaryfield(byte[] obj){
		this.binaryfield = obj;
	}

	public byte[] getBinaryfield(){
		return binaryfield;
	}

	public void setTextfield(String obj){
		this.textfield = obj;
	}

	public String getTextfield(){
		return textfield;
	}

	public void setTsvectorfield(String obj){
		this.tsvectorfield = obj;
	}

	public String getTsvectorfield(){
		return tsvectorfield;
	}

	public void setTsqueryfield(String obj){
		this.tsqueryfield = obj;
	}

	public String getTsqueryfield(){
		return tsqueryfield;
	}

	public void setBoxfield(String obj){
		this.boxfield = obj;
	}

	public String getBoxfield(){
		return boxfield;
	}

	public void setCirclefield(String obj){
		this.circlefield = obj;
	}

	public String getCirclefield(){
		return circlefield;
	}

	public void setLinefield(String obj){
		this.linefield = obj;
	}

	public String getLinefield(){
		return linefield;
	}

	public void setLsegfield(String obj){
		this.lsegfield = obj;
	}

	public String getLsegfield(){
		return lsegfield;
	}

	public void setPathfield(String obj){
		this.pathfield = obj;
	}

	public String getPathfield(){
		return pathfield;
	}

	public void setPointfield(String obj){
		this.pointfield = obj;
	}

	public String getPointfield(){
		return pointfield;
	}

	public void setPolygonfield(String obj){
		this.polygonfield = obj;
	}

	public String getPolygonfield(){
		return polygonfield;
	}

	public TestColumntypesDb2entity82(){
	}

	public TestColumntypesDb2entity82(int serialfield){
		this.serialfield = serialfield;
	}


public enum Field implements jef.database.Field{smallintfield,int2field,intfield2,bigintfield,decimalfield,numericfield,numericfield2,realfield,floatfield,doublefield,doublefield2,serialfield,serialfield2,moneyfield,varcharfield1,varcharfield2,charfield1,charfield2,varbitfield1,varbitfield2,bitfield1,bitfield2,cidrfield,inetfield,macaddrfield,booleanfield1,booleanfield2,datefield,timestampfield1,timestampfield2,timefield1,timefield2,intervalfield,binaryfield,textfield,tsvectorfield,tsqueryfield,boxfield,circlefield,linefield,lsegfield,pathfield,pointfield,polygonfield}
}
