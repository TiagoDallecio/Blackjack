package Blackjack;
import java.util.Scanner;
public class BlackjackTest {

    public static void main(String[] args)
    {

        int stop = 0;
        int cont = 2;
        Card hand[] =  new Card[6];

        
       DeckOfCards deck = new DeckOfCards();
       deck.shuffle();
       
        for(int i=0;i<=1;i++)
        {
            hand[i] = deck.dealCard();
            
        }
        
        System.out.println("Digite o numero de jogadores: ");
        Scanner number = new Scanner(System.in);
       
      

        Blackjack jogador1 = new Blackjack(0,hand);
        for(int i=0;i<=1;i++)
        {
            jogador1.setScore(hand, i);
        }

        System.out.printf("A mão do jogador vale: %d%n",jogador1.getScore());
        System.out.print("Cartas possuídas: ");
        for(int i=0;i<2;i++)
        {
            System.out.printf("%n%s",jogador1.getCard(i));
        }

        while(jogador1.getScore() < 21 || stop == 0)
        {
            System.out.println("Deseja receber outra carta?%n s ou n");
            Scanner resp = new Scanner(System.in);
            String resps = resp.nextLine();
            
            if(resps == "s")
            {
                jogador1.hand[cont] = deck.dealCard();
                System.out.printf("A mão do jogador vale: %d%n",jogador1.getScore());
                System.out.print("Cartas possuídas: ");

                for(int i=3;i<jogador1.hand.length;i++)
                {
                    System.out.printf("%n%s",jogador1.getCard(i));
                }
                cont++;
            }

            else
            {
                stop = 1;
            }

        }

    }
    
}
