
import java.util.Scanner;
public class BlackjackTest {

    public static void main(String[] args)
    {

        int stop;
        int cont;
        Card hand[][] =  new Card[7][7];
        int vencedor = 0;
        int vencedorindex = 0;
        
       DeckOfCards deck = new DeckOfCards();
       deck.shuffle();
        
        System.out.println("Digite o numero de jogadores: ");
        Scanner number = new Scanner(System.in);
        int num = number.nextInt();
        
        Blackjack players[] = new Blackjack[num+1];

        for(int i=1;i<=num;i++)
        {
            players[i] = new Blackjack(0, hand[i]); 

            for(int j=0;j<=1;j++)
            {
                hand[i][j] = deck.dealCard();
                players[i].setScore(hand, i, j);
            }  
        }

        for(int i = 1; i<=num; i++)
        {
            System.out.printf("%n%nA mão do jogador %d vale: %n%n%d%n",i,players[i].getScore());
            System.out.printf("%nCartas do jogador %d: ",i);
            for(int j=0;j<2;j++)
            {
                System.out.printf("%n%n%s",players[i].getCard(j));
            }
            System.out.printf("%n%n%n");
        }
    
        
        for(int i=1;i<=num;i++)
        {
            cont = 2;
            stop = 0;

            while(stop == 0)
            {
                if(players[i].getScore() == 21)
                {
                    System.out.printf("%n%nO jogador possui um Blackjack!");
                    stop = 1;
                }

                if(players[i].getScore() < 21)
                {

                    System.out.printf("%n%nO jogador %d deseja receber outra carta?", i);
                    System.out.printf("%nNúmero de pontos: %d",players[i].getScore());
                    System.out.printf("%ns ou n: ");
                    Scanner resp = new Scanner(System.in);
                    char resps = resp.next().charAt(0);
            
                    if(resps == 's')
                    {
                        hand[i][cont] = deck.dealCard();
                        players[i].setCard(hand[i][cont],cont);
                        players[i].setScore(hand, i, cont);
                        System.out.printf("%nA mão do jogador vale: %d%n",players[i].getScore());
                        System.out.print("Cartas possuídas: ");

                        for(int j=0;j<=cont;j++)
                        {
                            System.out.printf("%n%n%s",players[i].getCard(j));
                        }

                        cont++;
                    }

                    if(resps == 'n')
                    {
                        System.out.println("O jogador não quer mais cartas.");
                        stop = 1;
                    }
            }
                if(players[i].getScore()>21)
                {
                    System.out.printf("%n%nO jogador estourou!%n%n");
                    players[i].zeroScore();
                    stop = 1;
                }
        
            }

        }
        
        for(int i = 1; i<=num; i++)
        {
            if(players[i].getScore() > vencedor)
            {
                vencedor = players[i].getScore();
                vencedorindex = i;
            }
        }

        
        System.out.printf("%n%n%n O vencedor é jogador %d! %n %d pontos!%n%n",vencedorindex,vencedor);
        
    }

}


