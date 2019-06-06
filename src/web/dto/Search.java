package web.dto;

public class Search {

	private String fshlcNm;
	private String fshlcType;
	private String rdnmadr;
	private String lnmadr;
	private String fshlcPhoneNumber;
	private String latitude; 
	private String hardness; 
	private String kdfsh;

	private String useCharge;

	private String cvntl;
	private String cfrTrrsrt;

	private String insttNm;
	private String resultCode;
	
	
	@Override
	public String toString() {
		return "Search [fshlcNm=" + fshlcNm + ", fshlcType=" + fshlcType + ", rdnmadr=" + rdnmadr + ", lnmadr=" + lnmadr
				+ ", fshlcPhoneNumber=" + fshlcPhoneNumber + ", latitude=" + latitude + ", hardness=" + hardness
				+ ", kdfsh=" + kdfsh + ", useCharge=" + useCharge + ", cvntl=" + cvntl + ", cfrTrrsrt=" + cfrTrrsrt
				+ ", insttNm=" + insttNm + ", resultCode=" + resultCode + "]";
	}


	public String getFshlcNm() {
		return fshlcNm;
	}


	public void setFshlcNm(String fshlcNm) {
		this.fshlcNm = fshlcNm;
	}


	public String getFshlcType() {
		return fshlcType;
	}


	public void setFshlcType(String fshlcType) {
		this.fshlcType = fshlcType;
	}


	public String getRdnmadr() {
		return rdnmadr;
	}


	public void setRdnmadr(String rdnmadr) {
		this.rdnmadr = rdnmadr;
	}


	public String getLnmadr() {
		return lnmadr;
	}


	public void setLnmadr(String lnmadr) {
		this.lnmadr = lnmadr;
	}


	public String getFshlcPhoneNumber() {
		return fshlcPhoneNumber;
	}


	public void setFshlcPhoneNumber(String fshlcPhoneNumber) {
		this.fshlcPhoneNumber = fshlcPhoneNumber;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getHardness() {
		return hardness;
	}


	public void setHardness(String hardness) {
		this.hardness = hardness;
	}


	public String getKdfsh() {
		return kdfsh;
	}


	public void setKdfsh(String kdfsh) {
		this.kdfsh = kdfsh;
	}


	public String getUseCharge() {
		return useCharge;
	}


	public void setUseCharge(String useCharge) {
		this.useCharge = useCharge;
	}


	public String getCvntl() {
		return cvntl;
	}


	public void setCvntl(String cvntl) {
		this.cvntl = cvntl;
	}


	public String getCfrTrrsrt() {
		return cfrTrrsrt;
	}


	public void setCfrTrrsrt(String cfrTrrsrt) {
		this.cfrTrrsrt = cfrTrrsrt;
	}


	public String getInsttNm() {
		return insttNm;
	}


	public void setInsttNm(String insttNm) {
		this.insttNm = insttNm;
	}


	public String getResultCode() {
		return resultCode;
	}


	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	
	
	
}