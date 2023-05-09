package com.vanyailnitsk.scoreboard.config;

import com.vanyailnitsk.scoreboard.models.Role;
import com.vanyailnitsk.scoreboard.models.User;
import com.vanyailnitsk.scoreboard.repositories.*;
import com.vanyailnitsk.scoreboard.tasks.AlgorithmTask;
import com.vanyailnitsk.scoreboard.tasks.AlgorithmTaskResult;
import com.vanyailnitsk.scoreboard.tasks.TestResult;
import com.vanyailnitsk.scoreboard.tasks.TestTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Configuration
public class TestConfig {
    private final TestTaskRepository testTaskRepository;
    private final TestResultRepository testScoreRepository;
    private final UserRepository userRepository;
    private final AlgorithmTaskRepository algorithmTaskRepository;
    private final AlgorithmTaskResultRepository algorithmTaskResultRepository;
    private final PasswordEncoder passwordEncoder;

    public TestConfig(TestTaskRepository testTaskRepository,
                      TestResultRepository testScoreRepository,
                      UserRepository userRepository,
                      AlgorithmTaskRepository algorithmTaskRepository,
                      AlgorithmTaskResultRepository algorithmTaskResultRepository,
                      PasswordEncoder passwordEncoder) {
        this.testTaskRepository = testTaskRepository;
        this.testScoreRepository = testScoreRepository;
        this.userRepository = userRepository;
        this.algorithmTaskRepository = algorithmTaskRepository;
        this.algorithmTaskResultRepository = algorithmTaskResultRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return args -> {
            TestTask test1 = new TestTask("Тест по инфраструктуре VK");
            test1 = testTaskRepository.save(test1);
            User user = new User("Ivan","vanya",passwordEncoder.encode("pass"));
            user.setRoles(Set.of(Role.ROLE_USER));
            user = userRepository.save(user);
            TestResult testScore1 = new TestResult(test1,98);
            testScore1.setUser(user);
            testScoreRepository.save(testScore1);
            User user1 = new User("Kolya","kolya",passwordEncoder.encode("pass"));
            user1.setRoles(Set.of(Role.ROLE_USER));
            user1 = userRepository.save(user1);
            TestResult testResult = new TestResult(test1,100);
            testResult.setUser(user1);
            testScoreRepository.save(testResult);
            AlgorithmTask algorithmTask = new AlgorithmTask("Two Sum","Дан массив целых чисел num и целочисленное целевое значение, верните индексы двух чисел таким образом, чтобы они в сумме равнялись целевому значению.\n" +
                    "\nВы можете предположить, что каждый входной сигнал будет иметь ровно одно решение, и вы не можете использовать один и тот же элемент дважды.", List.of("Input: nums = [2,7,11,15], target = 9\n" +
                    "Output: [0,1]"));
            algorithmTask = algorithmTaskRepository.save(algorithmTask);
            AlgorithmTaskResult algorithmTaskResult = new AlgorithmTaskResult(user,algorithmTask,true);
            algorithmTaskResultRepository.save(algorithmTaskResult);
        };
    }
}
