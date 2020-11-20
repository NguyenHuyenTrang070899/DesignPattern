import java.util.Random;

public class Factory {
    public static void main(String[] args) {
        System.out.println("Chọn giống cho 12 nông dân ở Tây Nguyên");
        GiongCayTrongFactory tayNguyenFactory = new TayNguyenFactory();
        for (int i = 0; i < 12; i++) {
            Giong giongDuocChon = tayNguyenFactory.chonGiong();
            System.out.println("Nguời thứ " + (i + 1) + " nhận được giống của " + giongDuocChon.showTenGiong());
        }
        System.out.println("-----");
        System.out.println("Chọn giống cho 12 nông dân ở Đồng bằng sông Cửu Long");
        GiongCayTrongFactory dbSCLFactory = new DBSongCuuLongFactory();
        for (int i = 0; i < 12; i++) {
            Giong giongDuocChon = dbSCLFactory.chonGiong();
            System.out.println("Nguời thứ " + (i + 1) + " nhận được giống của " + giongDuocChon.showTenGiong());
        }
    }
}
interface Giong {
    public String showTenGiong();
}

// Cà phê
class CaPhe implements Giong {

    @Override
    public String showTenGiong() {
        return "Cà phê";
    }
}

// Tiêu
class Tieu implements Giong {

    @Override
    public String showTenGiong() {
        return "Tiêu";
    }
}

// Cao Su
class CaoSu implements Giong {

    @Override
    public String showTenGiong() {
        return "Cao Su";
    }
}


// Cam
class Cam implements Giong {

    @Override
    public String showTenGiong() {
        return "Cam";
    }
}

// Nhãn
class Nhan implements Giong {

    @Override
    public String showTenGiong() {
        return "Nhãn";
    }
}

// Xoài
class Xoai implements Giong {

    @Override
    public String showTenGiong() {
        return "Xoài";
    }
}

// Sầu riêng
class SauRieng implements Giong {

    @Override
    public String showTenGiong() {
        return "Sầu Riêng";
    }
}

interface GiongCayTrongFactory {
    public Giong chonGiong();
}

class TayNguyenFactory implements GiongCayTrongFactory {
    private Random chonGiongNgauNhien = new Random();
    @Override
    public Giong chonGiong() {

        switch (chonGiongNgauNhien.nextInt(3)) {
            case 0:
                return new CaPhe();
            case 1:
                return new Tieu();
            case 2:
                return new CaoSu();
            default:
                return null;
        }
    }
}

class DBSongCuuLongFactory implements GiongCayTrongFactory {

    private int count = 0;

    @Override
    public Giong chonGiong() {
        switch (count) {
            case 0:
                count ++;
                return new Cam();
            case 1:
                count ++;
                return new Xoai();
            case 2:
                count ++;
                return new Nhan();
            case 3:
                count = 0;
                return new SauRieng();
            default:
                count = 0;
                return null;
        }
    }
}

