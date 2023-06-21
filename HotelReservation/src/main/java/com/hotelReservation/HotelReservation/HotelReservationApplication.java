package com.hotelReservation.HotelReservation;

import com.hotelReservation.HotelReservation.entity.HotelDetails;
import com.hotelReservation.HotelReservation.repo.HotelDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class HotelReservationApplication implements CommandLineRunner {

	private final HotelDetailsRepo hotelDetailsRepo;

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		HotelDetails hotelDetails = new HotelDetails();
		hotelDetails.setRate(2000);
		hotelDetails.setWifi(true);
		hotelDetails.setRoomType("Junior Suite");
		hotelDetails.setAvailableRooms(5);
		hotelDetails.setNumberOfBeds(2);
		hotelDetails.setNumberOfBath(1);
		hotelDetails.setDescription("To enhance your comfort, our junior suite beds are adorned with high-quality linens, including premium bed sheets, pillows, and duvets. The linens are soft, smooth, and hypoallergenic, creating a cozy environment for a peaceful sleep.");

		hotelDetailsRepo.save(hotelDetails);


		HotelDetails hotelDetails1 = new HotelDetails();
		hotelDetails1.setDescription("In our executive suites, you will typically find a king-size bed, offering ample space for you to stretch out and unwind. The bed is thoughtfully crafted to provide a perfect balance between plushness and support, ensuring a peaceful sleep.\n" +
				"\n");
		hotelDetails1.setWifi(true);
		hotelDetails1.setRoomType("Executive Suite");
		hotelDetails1.setRate(3000);
		hotelDetails1.setAvailableRooms(6);
		hotelDetails1.setNumberOfBath(1);
		hotelDetails1.setNumberOfBeds(2);

		hotelDetailsRepo.save(hotelDetails1);


		HotelDetails hotelDetails2 = new HotelDetails();

		hotelDetails2.setWifi(false);
		hotelDetails2.setRate(5500);
		hotelDetails2.setDescription("The mattress on our Super Deluxe beds is of the highest quality, carefully selected to strike a perfect balance between softness and support. It is designed to conform to your body shape, relieving pressure points and a restful sleep.");
		hotelDetails2.setRoomType("Super Deluxe");
		hotelDetails2.setAvailableRooms(6);
		hotelDetails2.setNumberOfBeds(3);
		hotelDetails2.setNumberOfBath(2);

		hotelDetailsRepo.save(hotelDetails2);
	}

	}
