import java.sql.*;

public class Veritabani implements IVeritabani {

    private Connection baglan() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Device",
                    "postgres", "12345");
            if (connection == null)
                System.out.println("Veritabanına bağlanamadı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean dogrula(String username, String password) { // Kullanıcı doğrulaması yapılır
        try {
            boolean anahtar;

            Connection connection = this.baglan(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"User\" WHERE \"Username\"='" + username + "' and \"Password\"='" + password + "'";

            //Sorgu çalıştırılır.
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Bağlantı sonlandırılır
            connection.close();

            Thread.sleep(1000);
            if (!rs.next()) { // Veritabanından gelen sonuç seti boşsa kullanıcı bulunamaz.
                System.out.println("Kullanıcı bulunamadı.");
                anahtar = false;
            } else { // Veritabanından gelen sonuç seti boş değilse giriş doğrulanır.
                System.out.println("Giriş başarılı.");
                anahtar = true;
            }

            rs.close();
            stmt.close();
            return anahtar;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int minSicaklik(String username, String password)
    {
        int sicaklik=0;
        try
        {
            Connection connection = this.baglan();
            //String sql = "SELECT *  FROM \"User\"" ;
            String sql = "SELECT *  FROM \"User\" WHERE \"Username\"='" + username + "' and \"Password\"='" + password + "'";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                sicaklik = rs.getInt("min");
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sicaklik;
    }

    @Override
    public int maxSicaklik(String username, String password)
    {
        int sicaklik=0;
        try
        {
            Connection connection = this.baglan();
            //String sql = "SELECT *  FROM \"User\"" ;
            String sql = "SELECT *  FROM \"User\" WHERE \"Username\"='" + username + "' and \"Password\"='" + password + "'";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                sicaklik = rs.getInt("max");
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sicaklik;
    }

    @Override
    public String kullaniciAdi(String username, String password)
    {
        String isim="";
        try
        {
            Connection connection = this.baglan();
            //String sql = "SELECT *  FROM \"User\"" ;
            String sql = "SELECT *  FROM \"User\" WHERE \"Username\"='" + username + "' and \"Password\"='" + password + "'";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                isim = rs.getString("Name");
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return isim;
    }

    @Override
    public String kullaniciSoyadi(String username, String password)
    {
        String soyisim="";
        try
        {
            Connection connection = this.baglan();
            //String sql = "SELECT *  FROM \"User\"" ;
            String sql = "SELECT *  FROM \"User\" WHERE \"Username\"='" + username + "' and \"Password\"='" + password + "'";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                soyisim = rs.getString("Surname");
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return soyisim;
    }

    }
