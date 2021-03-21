package covid19.backend.Models.Covid19;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvBeanStateSeries implements Serializable {

    @CsvBindByName(column = "Date")
    private String date;
    @CsvBindByName(column = "Date_YMD")
    private String dateYMD;
    @CsvBindByName(column = "Status")
    private String status;
    @CsvBindByName(column = "TT")
    private Integer tT;
    @CsvBindByName(column = "AN")
    private Integer aN;
    @CsvBindByName(column = "AP")
    private Integer aP;
    @CsvBindByName(column = "AR")
    private Integer aR;
    @CsvBindByName(column = "AS")
    private Integer aS;
    @CsvBindByName(column = "BR")
    private Integer bR;
    @CsvBindByName(column = "CH")
    private Integer cH;
    @CsvBindByName(column = "CT")
    private Integer cT;
    @CsvBindByName(column = "DN")
    private Integer dN;
    @CsvBindByName(column = "DD")
    private Integer dD;
    @CsvBindByName(column = "DL")
    private Integer dL;
    @CsvBindByName(column = "GA")
    private Integer gA;
    @CsvBindByName(column = "GJ")
    private Integer gJ;
    @CsvBindByName(column = "HR")
    private Integer hR;
    @CsvBindByName(column = "HP")
    private Integer hP;
    @CsvBindByName(column = "JK")
    private Integer jK;
    @CsvBindByName(column = "JH")
    private Integer jH;
    @CsvBindByName(column = "KA")
    private Integer kA;
    @CsvBindByName(column = "KL")
    private Integer kL;
    @CsvBindByName(column = "LA")
    private Integer lA;
    @CsvBindByName(column = "LD")
    private Integer lD;
    @CsvBindByName(column = "MP")
    private Integer mP;
    @CsvBindByName(column = "MH")
    private Integer mH;
    @CsvBindByName(column = "MN")
    private Integer mN;
    @CsvBindByName(column = "ML")
    private Integer mL;
    @CsvBindByName(column = "MZ")
    private Integer mZ;
    @CsvBindByName(column = "NL")
    private Integer nL;
    @CsvBindByName(column = "OR")
    private Integer oR;
    @CsvBindByName(column = "PY")
    private Integer pY;
    @CsvBindByName(column = "PB")
    private Integer pB;
    @CsvBindByName(column = "RJ")
    private Integer rJ;
    @CsvBindByName(column = "SK")
    private Integer sK;
    @CsvBindByName(column = "TN")
    private Integer tN;
    @CsvBindByName(column = "TG")
    private Integer tG;
    @CsvBindByName(column = "TR")
    private Integer tR;
    @CsvBindByName(column = "UP")
    private Integer uP;
    @CsvBindByName(column = "UT")
    private Integer uT;
    @CsvBindByName(column = "WB")
    private Integer wB;
    @CsvBindByName(column = "UN")
    private Integer uN;

    public CsvBeanStateSeries() {
    }

    public CsvBeanStateSeries(String date, String dateYMD, String status, Integer tT, Integer aN, Integer aP, Integer aR, Integer aS, Integer bR, Integer cH, Integer cT, Integer dN, Integer dD, Integer dL, Integer gA, Integer gJ, Integer hR, Integer hP, Integer jK, Integer jH, Integer kA, Integer kL, Integer lA, Integer lD, Integer mP, Integer mH, Integer mN, Integer mL, Integer mZ, Integer nL, Integer oR, Integer pY, Integer pB, Integer rJ, Integer sK, Integer tN, Integer tG, Integer tR, Integer uP, Integer uT, Integer wB, Integer uN) {
        super();
        this.date = date;
        this.dateYMD = dateYMD;
        this.status = status;
        this.tT = tT;
        this.aN = aN;
        this.aP = aP;
        this.aR = aR;
        this.aS = aS;
        this.bR = bR;
        this.cH = cH;
        this.cT = cT;
        this.dN = dN;
        this.dD = dD;
        this.dL = dL;
        this.gA = gA;
        this.gJ = gJ;
        this.hR = hR;
        this.hP = hP;
        this.jK = jK;
        this.jH = jH;
        this.kA = kA;
        this.kL = kL;
        this.lA = lA;
        this.lD = lD;
        this.mP = mP;
        this.mH = mH;
        this.mN = mN;
        this.mL = mL;
        this.mZ = mZ;
        this.nL = nL;
        this.oR = oR;
        this.pY = pY;
        this.pB = pB;
        this.rJ = rJ;
        this.sK = sK;
        this.tN = tN;
        this.tG = tG;
        this.tR = tR;
        this.uP = uP;
        this.uT = uT;
        this.wB = wB;
        this.uN = uN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateYMD() {
        return dateYMD;
    }

    public void setDateYMD(String dateYMD) {
        this.dateYMD = dateYMD;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTT() {
        return tT;
    }

    public void setTT(Integer tT) {
        this.tT = tT;
    }

    public Integer getAN() {
        return aN;
    }

    public void setAN(Integer aN) {
        this.aN = aN;
    }

    public Integer getAP() {
        return aP;
    }

    public void setAP(Integer aP) {
        this.aP = aP;
    }

    public Integer getAR() {
        return aR;
    }

    public void setAR(Integer aR) {
        this.aR = aR;
    }

    public Integer getAS() {
        return aS;
    }

    public void setAS(Integer aS) {
        this.aS = aS;
    }

    public Integer getBR() {
        return bR;
    }

    public void setBR(Integer bR) {
        this.bR = bR;
    }

    public Integer getCH() {
        return cH;
    }

    public void setCH(Integer cH) {
        this.cH = cH;
    }

    public Integer getCT() {
        return cT;
    }

    public void setCT(Integer cT) {
        this.cT = cT;
    }

    public Integer getDN() {
        return dN;
    }

    public void setDN(Integer dN) {
        this.dN = dN;
    }

    public Integer getDD() {
        return dD;
    }

    public void setDD(Integer dD) {
        this.dD = dD;
    }

    public Integer getDL() {
        return dL;
    }

    public void setDL(Integer dL) {
        this.dL = dL;
    }

    public Integer getGA() {
        return gA;
    }

    public void setGA(Integer gA) {
        this.gA = gA;
    }

    public Integer getGJ() {
        return gJ;
    }

    public void setGJ(Integer gJ) {
        this.gJ = gJ;
    }

    public Integer getHR() {
        return hR;
    }

    public void setHR(Integer hR) {
        this.hR = hR;
    }

    public Integer getHP() {
        return hP;
    }

    public void setHP(Integer hP) {
        this.hP = hP;
    }

    public Integer getJK() {
        return jK;
    }

    public void setJK(Integer jK) {
        this.jK = jK;
    }

    public Integer getJH() {
        return jH;
    }

    public void setJH(Integer jH) {
        this.jH = jH;
    }

    public Integer getKA() {
        return kA;
    }

    public void setKA(Integer kA) {
        this.kA = kA;
    }

    public Integer getKL() {
        return kL;
    }

    public void setKL(Integer kL) {
        this.kL = kL;
    }

    public Integer getLA() {
        return lA;
    }

    public void setLA(Integer lA) {
        this.lA = lA;
    }

    public Integer getLD() {
        return lD;
    }

    public void setLD(Integer lD) {
        this.lD = lD;
    }

    public Integer getMP() {
        return mP;
    }

    public void setMP(Integer mP) {
        this.mP = mP;
    }

    public Integer getMH() {
        return mH;
    }

    public void setMH(Integer mH) {
        this.mH = mH;
    }

    public Integer getMN() {
        return mN;
    }

    public void setMN(Integer mN) {
        this.mN = mN;
    }

    public Integer getML() {
        return mL;
    }

    public void setML(Integer mL) {
        this.mL = mL;
    }

    public Integer getMZ() {
        return mZ;
    }

    public void setMZ(Integer mZ) {
        this.mZ = mZ;
    }

    public Integer getNL() {
        return nL;
    }

    public void setNL(Integer nL) {
        this.nL = nL;
    }

    public Integer getOR() {
        return oR;
    }

    public void setOR(Integer oR) {
        this.oR = oR;
    }

    public Integer getPY() {
        return pY;
    }

    public void setPY(Integer pY) {
        this.pY = pY;
    }

    public Integer getPB() {
        return pB;
    }

    public void setPB(Integer pB) {
        this.pB = pB;
    }

    public Integer getRJ() {
        return rJ;
    }

    public void setRJ(Integer rJ) {
        this.rJ = rJ;
    }

    public Integer getSK() {
        return sK;
    }

    public void setSK(Integer sK) {
        this.sK = sK;
    }

    public Integer getTN() {
        return tN;
    }

    public void setTN(Integer tN) {
        this.tN = tN;
    }

    public Integer getTG() {
        return tG;
    }

    public void setTG(Integer tG) {
        this.tG = tG;
    }

    public Integer getTR() {
        return tR;
    }

    public void setTR(Integer tR) {
        this.tR = tR;
    }

    public Integer getUP() {
        return uP;
    }

    public void setUP(Integer uP) {
        this.uP = uP;
    }

    public Integer getUT() {
        return uT;
    }

    public void setUT(Integer uT) {
        this.uT = uT;
    }

    public Integer getWB() {
        return wB;
    }

    public void setWB(Integer wB) {
        this.wB = wB;
    }

    public Integer getUN() {
        return uN;
    }

    public void setUN(Integer uN) {
        this.uN = uN;
    }

    public String getDateEpoch() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zz");
        Date date = null;
        try {
            date = df.parse(this.dateYMD + " 06:00:00 GMT+05:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return String.valueOf(date.getTime());
    }
}