package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "data_state_series")
public class MongoCasesStateSeries {

    @MongoId
    private String _id;
    private String date;
    private String status;
    private int tT;
    private int aN;
    private int aP;
    private int aR;
    private int aS;
    private int bR;
    private int cH;
    private int cT;
    private int dN;
    private int dD;
    private int dL;
    private int gA;
    private int gJ;
    private int hR;
    private int hP;
    private int jK;
    private int jH;
    private int kA;
    private int kL;
    private int lA;
    private int lD;
    private int mP;
    private int mH;
    private int mN;
    private int mL;
    private int mZ;
    private int nL;
    private int oR;
    private int pY;
    private int pB;
    private int rJ;
    private int sK;
    private int tN;
    private int tG;
    private int tR;
    private int uP;
    private int uT;
    private int wB;
    private int uN;

    public MongoCasesStateSeries() {
    }

    public MongoCasesStateSeries(String date, String status, int tT, int aN, int aP, int aR, int aS, int bR, int cH, int cT, int dN, int dD, int dL, int gA, int gJ, int hR, int hP, int jK, int jH, int kA, int kL, int lA, int lD, int mP, int mH, int mN, int mL, int mZ, int nL, int oR, int pY, int pB, int rJ, int sK, int tN, int tG, int tR, int uP, int uT, int wB, int uN) {
        this.date = date;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int gettT() {
        return tT;
    }

    public void settT(int tT) {
        this.tT = tT;
    }

    public int getaN() {
        return aN;
    }

    public void setaN(int aN) {
        this.aN = aN;
    }

    public int getaP() {
        return aP;
    }

    public void setaP(int aP) {
        this.aP = aP;
    }

    public int getaR() {
        return aR;
    }

    public void setaR(int aR) {
        this.aR = aR;
    }

    public int getaS() {
        return aS;
    }

    public void setaS(int aS) {
        this.aS = aS;
    }

    public int getbR() {
        return bR;
    }

    public void setbR(int bR) {
        this.bR = bR;
    }

    public int getcH() {
        return cH;
    }

    public void setcH(int cH) {
        this.cH = cH;
    }

    public int getcT() {
        return cT;
    }

    public void setcT(int cT) {
        this.cT = cT;
    }

    public int getdN() {
        return dN;
    }

    public void setdN(int dN) {
        this.dN = dN;
    }

    public int getdD() {
        return dD;
    }

    public void setdD(int dD) {
        this.dD = dD;
    }

    public int getdL() {
        return dL;
    }

    public void setdL(int dL) {
        this.dL = dL;
    }

    public int getgA() {
        return gA;
    }

    public void setgA(int gA) {
        this.gA = gA;
    }

    public int getgJ() {
        return gJ;
    }

    public void setgJ(int gJ) {
        this.gJ = gJ;
    }

    public int gethR() {
        return hR;
    }

    public void sethR(int hR) {
        this.hR = hR;
    }

    public int gethP() {
        return hP;
    }

    public void sethP(int hP) {
        this.hP = hP;
    }

    public int getjK() {
        return jK;
    }

    public void setjK(int jK) {
        this.jK = jK;
    }

    public int getjH() {
        return jH;
    }

    public void setjH(int jH) {
        this.jH = jH;
    }

    public int getkA() {
        return kA;
    }

    public void setkA(int kA) {
        this.kA = kA;
    }

    public int getkL() {
        return kL;
    }

    public void setkL(int kL) {
        this.kL = kL;
    }

    public int getlA() {
        return lA;
    }

    public void setlA(int lA) {
        this.lA = lA;
    }

    public int getlD() {
        return lD;
    }

    public void setlD(int lD) {
        this.lD = lD;
    }

    public int getmP() {
        return mP;
    }

    public void setmP(int mP) {
        this.mP = mP;
    }

    public int getmH() {
        return mH;
    }

    public void setmH(int mH) {
        this.mH = mH;
    }

    public int getmN() {
        return mN;
    }

    public void setmN(int mN) {
        this.mN = mN;
    }

    public int getmL() {
        return mL;
    }

    public void setmL(int mL) {
        this.mL = mL;
    }

    public int getmZ() {
        return mZ;
    }

    public void setmZ(int mZ) {
        this.mZ = mZ;
    }

    public int getnL() {
        return nL;
    }

    public void setnL(int nL) {
        this.nL = nL;
    }

    public int getoR() {
        return oR;
    }

    public void setoR(int oR) {
        this.oR = oR;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public int getpB() {
        return pB;
    }

    public void setpB(int pB) {
        this.pB = pB;
    }

    public int getrJ() {
        return rJ;
    }

    public void setrJ(int rJ) {
        this.rJ = rJ;
    }

    public int getsK() {
        return sK;
    }

    public void setsK(int sK) {
        this.sK = sK;
    }

    public int gettN() {
        return tN;
    }

    public void settN(int tN) {
        this.tN = tN;
    }

    public int gettG() {
        return tG;
    }

    public void settG(int tG) {
        this.tG = tG;
    }

    public int gettR() {
        return tR;
    }

    public void settR(int tR) {
        this.tR = tR;
    }

    public int getuP() {
        return uP;
    }

    public void setuP(int uP) {
        this.uP = uP;
    }

    public int getuT() {
        return uT;
    }

    public void setuT(int uT) {
        this.uT = uT;
    }

    public int getwB() {
        return wB;
    }

    public void setwB(int wB) {
        this.wB = wB;
    }

    public int getuN() {
        return uN;
    }

    public void setuN(int uN) {
        this.uN = uN;
    }
}
