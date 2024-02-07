/**
  * @author mshujo2s
 */
public class Datum {

    private int jahr;
    private int monat;
    private int tag;
    private static String rf;
    private static  char tz;

    public Datum(int jahr, int monat, int tag){
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
        this.rf = "jmt";
        this.tz = '-';
    }

    public Datum(){
        this(1,1,1);
    }

    public Datum(int jahr){
        this(jahr,1,1);
    }

    public Datum(int jahr, int monat){
        this(jahr,monat,1);
    }

    public Datum(Datum dat){
        this(dat.jahr,dat.monat,dat.tag);
    }

    public int jahr() {
        return jahr;
    }

    public int monat() {
        return monat;
    }

    public int tag() {
        return tag;
    }

    public boolean equals(Datum dat){
        if (this.jahr == dat.jahr() && this.monat == dat.monat() && this.tag == dat.tag()) {
            return true;
        }
        else{ return false;
        }
    }

    public boolean istFrueher(Datum dat) {

        boolean ret = false;

        if (this.jahr < dat.jahr()) {
            ret = true;
        } else if (this.jahr == dat.jahr() && this.monat < dat.monat()) {
            ret = true;
        } else if (this.jahr == dat.jahr() && this.monat == dat.monat() && this.tag < dat.tag()) {
            ret = true;
        }
        return ret;
    }
    @Override
    public String toString(){
        String s = "";
        s += getArg(rf.substring(0,1));
        for (int i = 1; i< rf.length(); i++){
            s +=  tz +getArg(rf.substring(i,i+1));
        }
        return s;
    }

    private String getArg(String s){
        switch (s){
            case "t":
                return String.format("%02d", this.tag);
            case "m":
                return String.format("%02d", this.monat);
            case "j":
                return "" + this.jahr;
            default:
                return  "-1";
        }
    }

    public static void setFormatRF(String s){
        rf = s;
    }

    public static void setFormatTZ(char s){
        tz = s;
    }

    public static boolean istSchaltjahr(int n){

        if ((n%4) == 0) {
            if (n < 1583)
                return true;
            if ((n % 100) == 0) {
                if ((n % 400) == 0) {
                    return true;
                } else return false;
            }
            return false;
        }
        return false;
    }

}
