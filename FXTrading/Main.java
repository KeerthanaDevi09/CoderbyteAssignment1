package codebyte;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double tradeRate=66.0;
		ArrayList<BookTrade> trades = new ArrayList<>(); 
		while(true)
		{
			System.out.println("Select any one of the option \n 1.Book \n 2.Print Trade\n 3.Exit");
			int option=sc.nextInt();
			if(option==1)
			{
				System.out.println("Enter customer Name:");
				sc.nextLine();
                		String customerName = sc.nextLine();

                		System.out.println("Enter Currency Pair:");
                		String currencyPair = sc.nextLine();

				if(!currencyPair.equalsIgnoreCase("USDINR"))
				{
					System.out.println("Invalid Currency Pair. Only USDINR is supported (e.g., USDINR)");
					break;
				}
				System.out.println("Enter Amount to be Transfer: ");
				double amount=sc.nextInt();
				if(amount<=0)
				{
					System.out.println("Please enter a valid amount");
					amount=sc.nextInt();
				}
				System.out.println("Do you want to get Rate (Yes/No): ");
				String getRate=sc.next();
				BookTrade b=new BookTrade(currencyPair,customerName,amount,tradeRate);
				if(getRate.equalsIgnoreCase("Yes"))
				{
					b.displayDetails();
				}
				System.out.println("Book or cancle this Trade (Book/Cancle)");
				String bookOrcancle=sc.next();
				if(bookOrcancle.equalsIgnoreCase("Book"))
				{
					trades.add(b);
					b.bookTrade();
				}
				else
				{
					System.out.println("Trade is Cancled");
				}
			}
			else if(option==2)
			{
				System.out.println("TradeNo   Currency Pair   CustomerName   Amount      Rate");
                		for (BookTrade trade : trades) {
                    			System.out.println(trade.toString());
                		}
			}
			else if(option==3)
			{
				System.out.println("Do you really want to exit (y/n): ");
				String exitConfirm=sc.next();
				if(exitConfirm.equalsIgnoreCase("Y"))
				{
					System.out.println("Bye - Have a good day!");
					sc.close();
					System.exit(0);
				}
			}
			else
			{
				System.out.println("Please select from the above three options");
			}
		}
	}

}
