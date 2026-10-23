package ipic.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages="ipic")
public class IpicApiApplication {
  public static void main(String[] args){ SpringApplication.run(IpicApiApplication.class,args); }
}