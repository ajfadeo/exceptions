package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: checkOut must be after checkIn");
		}
		else {
			Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
			System.out.println("Reservation = " + reservation);
			System.out.println();
			System.out.println("Enter data to update de reservatio: ");
			System.out.println("Ckeck-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Ckeck-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates in update must be in future");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro in reservation: checkOut must be after checkIn");
			}

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation = " + reservation);
	
		}
		
		sc.close();
	}

}
