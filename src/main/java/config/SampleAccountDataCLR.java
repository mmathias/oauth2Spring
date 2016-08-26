package config;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleAccountDataCLR implements CommandLineRunner {

    private AccountRepository accountRepository;

    @Autowired
    public SampleAccountDataCLR(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("admin,admin", "guest,guest")
                .map(t -> t.split(","))
                .forEach(tuple -> accountRepository.save(new Account(
                        tuple[0],
                        tuple[1],
                        true
                )));

        accountRepository.findAll().stream().forEach(acc -> System.out.println(acc.toString()));
    }
}
