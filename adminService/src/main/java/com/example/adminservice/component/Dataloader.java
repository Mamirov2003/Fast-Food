package com.example.adminservice.component;

import com.example.adminservice.entity.*;
import com.example.adminservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {
    private final AddressRepository addressRepository;
    private final AttachmentRepository attachmentRepository;
    private final CategoryRepository categoryRepository;
    private final DetailRepository detailRepository;
    private final DiscountRepository discountRepository;
    private final FavouriteRepository favouriteRepository;
    private final FilialRepository filialRepository;
    private final NotificationRepository notificationRepository;
    private final OrderRepository orderRepository;
    private final OrderHistoryRepository orderHistoryRepository;
    private final ProductRepository productRepository;
    private final RoleRepository roleRepository;
    private final SaleRepository saleRepository;
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {
            roleRepository.save(new Role(1l, "ADMIN"));
            roleRepository.save(new Role(2l, "USER"));
            roleRepository.save(new Role(3l, "OPERATOR"));
            roleRepository.save(new Role(4l, "DISPECHER"));
            roleRepository.save(new Role(5l, "CURIER"));

            Address qattadir = addressRepository.save(new Address(1l,"Qattadir",123D, 321D, "Qattadir"));
            Address qatdir = addressRepository.save(new Address(2l,"Qatdir",12345D, 54321D, "Qatdir"));


            //qolganlari xato berdi shunga commentga olib qo`ydim

//            Date startTime = new Date();
//            startTime.setHours(8);
//            Date endTime = new Date();
//            endTime.setHours(23);
//            filialRepository.save(new Filial(1l,"Sergeli","Сергели",startTime,endTime,qattadir));
//            filialRepository.save(new Filial(2l,"Chilonzor","Чилонзар",startTime,endTime,qatdir));

//            categoryRepository.save(new Category(1l,"Telefonlar","Телефоны"));
//            categoryRepository.save(new Category(2l,"Avtomabillar","Машины"));

//            Timestamp start = new Timestamp(2022,8,12,8,0,0,0);
//            Timestamp end = new Timestamp(2022,12,12,22,0,0,0);
//            saleRepository.save(new Sale(1l,"Super aksiya","Супер акция",start,end,100000d,5d));

        }
    }
}
