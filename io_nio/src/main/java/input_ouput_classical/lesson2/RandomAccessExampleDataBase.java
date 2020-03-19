package input_ouput_classical.lesson2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * @author Sergey Zhernovoy
 * create on 09.10.2017.
 * RandomAccessFile используются для создания разделенных файлов баз данных
 * , где простые файлы организованы как записи и поля.
 *
 */


public class RandomAccessExampleDataBase implements Serializable{

    public final static int PNUMLEN = 20;
    public final static int DESCLEN = 30;
    public final static int QUANLEN = 4;
    public final static int COSTLEN = 4;

    public final static int RECLEN =  2 * PNUMLEN  + 2 * DESCLEN + QUANLEN + COSTLEN;

    private RandomAccessFile raf;

    public RandomAccessExampleDataBase(String path, String mode) throws FileNotFoundException {
        this.raf = new RandomAccessFile(path,mode);
    }

    public void append(String partnum, String partdesc, int qty, int ucost) throws IOException{
        raf.seek(raf.length());
        write(partnum,partdesc,qty,ucost);
    }

    private void write(String partnum, String partdesc, int qty, int ucost) throws IOException {
        StringBuffer sb = new StringBuffer(partnum);
        if(sb.length() > PNUMLEN){
            sb.setLength(PNUMLEN);
        } else {
            if(sb.length() < PNUMLEN){
                int len = PNUMLEN - sb.length();
                for(int i = 0; i < len; i++){
                    sb.append(" ");
                }
            }
        }
        raf.writeChars(sb.toString());
        sb = new StringBuffer(partdesc);
        if(sb.length() > DESCLEN){
            sb.setLength(DESCLEN);
        } else {
            if(sb.length() < DESCLEN){
                int len = DESCLEN - sb.length();
                for(int i = 0; i < len; i++){
                    sb.append(" ");
                }
            }
        }
        raf.writeChars(sb.toString());
        raf.writeInt(qty);
        raf.writeInt(ucost);
    }

    public void close(){
        try{
            raf.close();
        } catch (IOException exc){
            System.err.println(exc);
        }
    }

    public int numRecs() throws IOException {
        return (int) raf.length() / RECLEN;
    }

    public Part select(int recno) throws IOException{
        if(recno < 0 || recno >= numRecs()) {
            throw  new IllegalArgumentException(recno + "  out of range");
        }
        raf.seek(recno * RECLEN);
        return read();
    }

    public void update(int recno, String partnum, String partdesc, int qty, int ucost) throws IOException{
        if(recno < 0 || recno >= numRecs()) {
            throw  new IllegalArgumentException(recno + "  out of range");
        }
        raf.seek(recno * RECLEN);
        write(partnum, partdesc,qty,ucost);
    }

    private Part read() throws IOException{
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < PNUMLEN; i++){
            sb.append(raf.readChar());
        }

        String partnum = sb.toString().trim();
        sb.setLength(0);
        for(int i = 0; i < DESCLEN ; i++){
            sb.append(raf.readChar());
        }
        String partdesc = sb.toString().trim();
        int qty = raf.readInt();
        int ucost = raf.readInt();
        return new Part(partnum,partdesc,qty,ucost);
    }


    public static class Part {

        private String partnum;
        private String desc;
        private int qty;
        private int ucost;


        public Part(String partnum, String desc, int qty, int ucost) {
            this.partnum = partnum;
            this.desc = desc;
            this.qty = qty;
            this.ucost = ucost;
        }

        public String getPartnum() {
            return partnum;
        }

        public String getDesc() {
            return desc;
        }

        public int getQty() {
            return qty;
        }

        public int getUcost() {
            return ucost;
        }
    }

    public static void main(String[] args) throws IOException {
        RandomAccessExampleDataBase randomAccessExampleDataBase = new RandomAccessExampleDataBase("d:\\MyBase.rds", "rw");
        randomAccessExampleDataBase.append("first","Ferrari", 10, 100000);
        randomAccessExampleDataBase.append("second","Mazda", 2, 12000);
        randomAccessExampleDataBase.append("third","Opel", 3, 100000);
        randomAccessExampleDataBase.append("forth","BMW", 5, 100000);

        RandomAccessExampleDataBase.Part record = randomAccessExampleDataBase.select(1);
        System.out.println(record.getPartnum() + " " + record.getDesc() + " "+ record.getQty() + " "+ record.getUcost());

    }


}

    