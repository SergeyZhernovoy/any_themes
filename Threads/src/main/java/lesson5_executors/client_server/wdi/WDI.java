package lesson5_executors.client_server.wdi;/*
 * Created Sergey Zhernovoy
 * on 09.12.2017 at 13:58
 */

public class WDI {

    public final static short FIRST_YEAR=1960;

    private String countryName;
    private String countryCode;
    private String indicatorName;
    private String indicatorCode;
    private Double values[];

    public void setData(String[] data) throws Exception {

        if (data.length!=63) {
            throw new Exception("Data length is not correct: "+ data.length);
        }
        values=new Double[59];
        countryName=getString(data[0]);
        countryCode=getString(data[1]);
        indicatorName=getString(data[2]);
        indicatorCode=getString(data[3]);

        for(int index = 4,indexValue = 0; index < data.length;index++, indexValue++){
            values[indexValue] = getValue(data[index]);
        }
    }

    private String getString(String string) {
        if (string.startsWith("\"")) {
            return string.substring(1,string.length()-1);
        }
        return string;
    }

    private Double getValue(String string) {
        if (string.trim().length()==0) {
            return 0.0d;
        }
        return Double.valueOf(string);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getIndicatorCode() {
        return indicatorCode;
    }

    public void setIndicatorCode(String indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    public Double getValue(short year) throws Exception {
        if ((year < FIRST_YEAR ) || (year >= FIRST_YEAR+values.length)) {
            throw new Exception ("No data for that year");
        }

        short index=(short)(year-FIRST_YEAR);
        return values[index];
    }

    public Double[] getValues() {
        return values;
    }

}
