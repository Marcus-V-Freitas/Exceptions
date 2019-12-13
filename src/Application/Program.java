package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Reservation;
import Exceptions.DomainExceptions;

public class Program {
	public static void main(String[] args)  {
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
		System.out.println("Número do quarto: ");
		int roomNumber=sc.nextInt();
		System.out.println("Data de Check-in");
		Date checkin=sdf.parse(sc.next());
		System.out.println("Data de Check-out");
		Date checkout=sdf.parse(sc.next());
		Reservation reservation=new Reservation(roomNumber,checkin, checkout);
		
		System.out.println(reservation);
		
		System.out.println("Digite datas novas para alterar");
		checkin=sdf.parse(sc.next());
		checkout=sdf.parse(sc.next());
		reservation.updateDates(checkin, checkout);
		
		System.out.println(reservation);
		}catch(InputMismatchException e) {
			System.out.println("Invalid value.");
		}catch(ParseException e) {
			System.out.println("Invalid Format");
		}catch(DomainExceptions e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		sc.close();
	}
}
