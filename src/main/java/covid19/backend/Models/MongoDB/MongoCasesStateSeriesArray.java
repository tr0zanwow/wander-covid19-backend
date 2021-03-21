package covid19.backend.Models.MongoDB;

import java.util.ArrayList;

public class MongoCasesStateSeriesArray {
    private MongoCasesStateSeries maharashtra;
    private MongoCasesStateSeries kerala;
    private MongoCasesStateSeries karnataka;
    private MongoCasesStateSeries andhraPradesh;
    private MongoCasesStateSeries tamilNadu;
    private MongoCasesStateSeries delhi;
    private MongoCasesStateSeries uttarPradesh;
    private MongoCasesStateSeries westBengal;
    private MongoCasesStateSeries odisha;
    private MongoCasesStateSeries rajasthan;
    private MongoCasesStateSeries chhattisgarh;
    private MongoCasesStateSeries telangana;
    private MongoCasesStateSeries haryana;
    private MongoCasesStateSeries gujarat;
    private MongoCasesStateSeries bihar;
    private MongoCasesStateSeries madhyaPradesh;
    private MongoCasesStateSeries assam;
    private MongoCasesStateSeries punjab;
    private MongoCasesStateSeries jammuKashmir;
    private MongoCasesStateSeries jharkhand;
    private MongoCasesStateSeries uttarakhand;
    private MongoCasesStateSeries himachalPradesh;
    private MongoCasesStateSeries goa;
    private MongoCasesStateSeries puducherry;
    private MongoCasesStateSeries tripura;
    private MongoCasesStateSeries manipur;
    private MongoCasesStateSeries chandigarh;
    private MongoCasesStateSeries arunachalPradesh;
    private MongoCasesStateSeries meghalaya;
    private MongoCasesStateSeries nagaland;
    private MongoCasesStateSeries ladakh;
    private MongoCasesStateSeries sikkim;
    private MongoCasesStateSeries andamanNicobarIslands;
    private MongoCasesStateSeries mizoram;
    private MongoCasesStateSeries damanDiu;
    private MongoCasesStateSeries lakshadweep;

    public MongoCasesStateSeriesArray() {
        this.maharashtra = new MongoCasesStateSeries("Maharashtra",new ArrayList<>());
        this.kerala = new MongoCasesStateSeries();
        this.karnataka = new MongoCasesStateSeries();
        this.andhraPradesh = new MongoCasesStateSeries();
        this.tamilNadu = new MongoCasesStateSeries();
        this.delhi = new MongoCasesStateSeries();
        this.uttarPradesh = new MongoCasesStateSeries();
        this.westBengal = new MongoCasesStateSeries();
        this.odisha = new MongoCasesStateSeries();
        this.rajasthan = new MongoCasesStateSeries();
        this.chhattisgarh = new MongoCasesStateSeries();
        this.telangana = new MongoCasesStateSeries();
        this.haryana = new MongoCasesStateSeries();
        this.gujarat = new MongoCasesStateSeries();
        this.bihar = new MongoCasesStateSeries();
        this.madhyaPradesh = new MongoCasesStateSeries();
        this.assam = new MongoCasesStateSeries();
        this.punjab = new MongoCasesStateSeries();
        this.jammuKashmir = new MongoCasesStateSeries();
        this.jharkhand = new MongoCasesStateSeries();
        this.uttarakhand = new MongoCasesStateSeries();
        this.himachalPradesh = new MongoCasesStateSeries();
        this.goa = new MongoCasesStateSeries();
        this.puducherry = new MongoCasesStateSeries();
        this.tripura = new MongoCasesStateSeries();
        this.manipur = new MongoCasesStateSeries();
        this.chandigarh = new MongoCasesStateSeries();
        this.arunachalPradesh = new MongoCasesStateSeries();
        this.meghalaya = new MongoCasesStateSeries();
        this.nagaland = new MongoCasesStateSeries();
        this.ladakh = new MongoCasesStateSeries();
        this.sikkim = new MongoCasesStateSeries();
        this.andamanNicobarIslands = new MongoCasesStateSeries();
        this.mizoram = new MongoCasesStateSeries();
        this.damanDiu = new MongoCasesStateSeries();
        this.lakshadweep = new MongoCasesStateSeries();
    }

    public MongoCasesStateSeriesArray(MongoCasesStateSeries maharashtra, MongoCasesStateSeries kerala, MongoCasesStateSeries karnataka, MongoCasesStateSeries andhraPradesh, MongoCasesStateSeries tamilNadu, MongoCasesStateSeries delhi, MongoCasesStateSeries uttarPradesh, MongoCasesStateSeries westBengal, MongoCasesStateSeries odisha, MongoCasesStateSeries rajasthan, MongoCasesStateSeries chhattisgarh, MongoCasesStateSeries telangana, MongoCasesStateSeries haryana, MongoCasesStateSeries gujarat, MongoCasesStateSeries bihar, MongoCasesStateSeries madhyaPradesh, MongoCasesStateSeries assam, MongoCasesStateSeries punjab, MongoCasesStateSeries jammuKashmir, MongoCasesStateSeries jharkhand, MongoCasesStateSeries uttarakhand, MongoCasesStateSeries himachalPradesh, MongoCasesStateSeries goa, MongoCasesStateSeries puducherry, MongoCasesStateSeries tripura, MongoCasesStateSeries manipur, MongoCasesStateSeries chandigarh, MongoCasesStateSeries arunachalPradesh, MongoCasesStateSeries meghalaya, MongoCasesStateSeries nagaland, MongoCasesStateSeries ladakh, MongoCasesStateSeries sikkim, MongoCasesStateSeries andamanNicobarIslands, MongoCasesStateSeries mizoram, MongoCasesStateSeries damanDiu, MongoCasesStateSeries lakshadweep) {
        this.maharashtra = maharashtra;
        this.kerala = kerala;
        this.karnataka = karnataka;
        this.andhraPradesh = andhraPradesh;
        this.tamilNadu = tamilNadu;
        this.delhi = delhi;
        this.uttarPradesh = uttarPradesh;
        this.westBengal = westBengal;
        this.odisha = odisha;
        this.rajasthan = rajasthan;
        this.chhattisgarh = chhattisgarh;
        this.telangana = telangana;
        this.haryana = haryana;
        this.gujarat = gujarat;
        this.bihar = bihar;
        this.madhyaPradesh = madhyaPradesh;
        this.assam = assam;
        this.punjab = punjab;
        this.jammuKashmir = jammuKashmir;
        this.jharkhand = jharkhand;
        this.uttarakhand = uttarakhand;
        this.himachalPradesh = himachalPradesh;
        this.goa = goa;
        this.puducherry = puducherry;
        this.tripura = tripura;
        this.manipur = manipur;
        this.chandigarh = chandigarh;
        this.arunachalPradesh = arunachalPradesh;
        this.meghalaya = meghalaya;
        this.nagaland = nagaland;
        this.ladakh = ladakh;
        this.sikkim = sikkim;
        this.andamanNicobarIslands = andamanNicobarIslands;
        this.mizoram = mizoram;
        this.damanDiu = damanDiu;
        this.lakshadweep = lakshadweep;
    }

    public MongoCasesStateSeries getMaharashtra() {
        return maharashtra;
    }

    public void setMaharashtra(MongoCasesStateSeries maharashtra) {
        this.maharashtra = maharashtra;
    }

    public MongoCasesStateSeries getKerala() {
        return kerala;
    }

    public void setKerala(MongoCasesStateSeries kerala) {
        this.kerala = kerala;
    }

    public MongoCasesStateSeries getKarnataka() {
        return karnataka;
    }

    public void setKarnataka(MongoCasesStateSeries karnataka) {
        this.karnataka = karnataka;
    }

    public MongoCasesStateSeries getAndhraPradesh() {
        return andhraPradesh;
    }

    public void setAndhraPradesh(MongoCasesStateSeries andhraPradesh) {
        this.andhraPradesh = andhraPradesh;
    }

    public MongoCasesStateSeries getTamilNadu() {
        return tamilNadu;
    }

    public void setTamilNadu(MongoCasesStateSeries tamilNadu) {
        this.tamilNadu = tamilNadu;
    }

    public MongoCasesStateSeries getDelhi() {
        return delhi;
    }

    public void setDelhi(MongoCasesStateSeries delhi) {
        this.delhi = delhi;
    }

    public MongoCasesStateSeries getUttarPradesh() {
        return uttarPradesh;
    }

    public void setUttarPradesh(MongoCasesStateSeries uttarPradesh) {
        this.uttarPradesh = uttarPradesh;
    }

    public MongoCasesStateSeries getWestBengal() {
        return westBengal;
    }

    public void setWestBengal(MongoCasesStateSeries westBengal) {
        this.westBengal = westBengal;
    }

    public MongoCasesStateSeries getOdisha() {
        return odisha;
    }

    public void setOdisha(MongoCasesStateSeries odisha) {
        this.odisha = odisha;
    }

    public MongoCasesStateSeries getRajasthan() {
        return rajasthan;
    }

    public void setRajasthan(MongoCasesStateSeries rajasthan) {
        this.rajasthan = rajasthan;
    }

    public MongoCasesStateSeries getChhattisgarh() {
        return chhattisgarh;
    }

    public void setChhattisgarh(MongoCasesStateSeries chhattisgarh) {
        this.chhattisgarh = chhattisgarh;
    }

    public MongoCasesStateSeries getTelangana() {
        return telangana;
    }

    public void setTelangana(MongoCasesStateSeries telangana) {
        this.telangana = telangana;
    }

    public MongoCasesStateSeries getHaryana() {
        return haryana;
    }

    public void setHaryana(MongoCasesStateSeries haryana) {
        this.haryana = haryana;
    }

    public MongoCasesStateSeries getGujarat() {
        return gujarat;
    }

    public void setGujarat(MongoCasesStateSeries gujarat) {
        this.gujarat = gujarat;
    }

    public MongoCasesStateSeries getBihar() {
        return bihar;
    }

    public void setBihar(MongoCasesStateSeries bihar) {
        this.bihar = bihar;
    }

    public MongoCasesStateSeries getMadhyaPradesh() {
        return madhyaPradesh;
    }

    public void setMadhyaPradesh(MongoCasesStateSeries madhyaPradesh) {
        this.madhyaPradesh = madhyaPradesh;
    }

    public MongoCasesStateSeries getAssam() {
        return assam;
    }

    public void setAssam(MongoCasesStateSeries assam) {
        this.assam = assam;
    }

    public MongoCasesStateSeries getPunjab() {
        return punjab;
    }

    public void setPunjab(MongoCasesStateSeries punjab) {
        this.punjab = punjab;
    }

    public MongoCasesStateSeries getJammuKashmir() {
        return jammuKashmir;
    }

    public void setJammuKashmir(MongoCasesStateSeries jammuKashmir) {
        this.jammuKashmir = jammuKashmir;
    }

    public MongoCasesStateSeries getJharkhand() {
        return jharkhand;
    }

    public void setJharkhand(MongoCasesStateSeries jharkhand) {
        this.jharkhand = jharkhand;
    }

    public MongoCasesStateSeries getUttarakhand() {
        return uttarakhand;
    }

    public void setUttarakhand(MongoCasesStateSeries uttarakhand) {
        this.uttarakhand = uttarakhand;
    }

    public MongoCasesStateSeries getHimachalPradesh() {
        return himachalPradesh;
    }

    public void setHimachalPradesh(MongoCasesStateSeries himachalPradesh) {
        this.himachalPradesh = himachalPradesh;
    }

    public MongoCasesStateSeries getGoa() {
        return goa;
    }

    public void setGoa(MongoCasesStateSeries goa) {
        this.goa = goa;
    }

    public MongoCasesStateSeries getPuducherry() {
        return puducherry;
    }

    public void setPuducherry(MongoCasesStateSeries puducherry) {
        this.puducherry = puducherry;
    }

    public MongoCasesStateSeries getTripura() {
        return tripura;
    }

    public void setTripura(MongoCasesStateSeries tripura) {
        this.tripura = tripura;
    }

    public MongoCasesStateSeries getManipur() {
        return manipur;
    }

    public void setManipur(MongoCasesStateSeries manipur) {
        this.manipur = manipur;
    }

    public MongoCasesStateSeries getChandigarh() {
        return chandigarh;
    }

    public void setChandigarh(MongoCasesStateSeries chandigarh) {
        this.chandigarh = chandigarh;
    }

    public MongoCasesStateSeries getArunachalPradesh() {
        return arunachalPradesh;
    }

    public void setArunachalPradesh(MongoCasesStateSeries arunachalPradesh) {
        this.arunachalPradesh = arunachalPradesh;
    }

    public MongoCasesStateSeries getMeghalaya() {
        return meghalaya;
    }

    public void setMeghalaya(MongoCasesStateSeries meghalaya) {
        this.meghalaya = meghalaya;
    }

    public MongoCasesStateSeries getNagaland() {
        return nagaland;
    }

    public void setNagaland(MongoCasesStateSeries nagaland) {
        this.nagaland = nagaland;
    }

    public MongoCasesStateSeries getLadakh() {
        return ladakh;
    }

    public void setLadakh(MongoCasesStateSeries ladakh) {
        this.ladakh = ladakh;
    }

    public MongoCasesStateSeries getSikkim() {
        return sikkim;
    }

    public void setSikkim(MongoCasesStateSeries sikkim) {
        this.sikkim = sikkim;
    }

    public MongoCasesStateSeries getAndamanNicobarIslands() {
        return andamanNicobarIslands;
    }

    public void setAndamanNicobarIslands(MongoCasesStateSeries andamanNicobarIslands) {
        this.andamanNicobarIslands = andamanNicobarIslands;
    }

    public MongoCasesStateSeries getMizoram() {
        return mizoram;
    }

    public void setMizoram(MongoCasesStateSeries mizoram) {
        this.mizoram = mizoram;
    }

    public MongoCasesStateSeries getDamanDiu() {
        return damanDiu;
    }

    public void setDamanDiu(MongoCasesStateSeries damanDiu) {
        this.damanDiu = damanDiu;
    }

    public MongoCasesStateSeries getLakshadweep() {
        return lakshadweep;
    }

    public void setLakshadweep(MongoCasesStateSeries lakshadweep) {
        this.lakshadweep = lakshadweep;
    }
}
