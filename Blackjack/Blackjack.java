
public class Blackjack {

    private int score;
    private Card[] cards = new Card[7];
    private Card dealc;
    private String faces;
    private int qtd = 0;
    

            public static DeckOfCards newDeck(){
                
                DeckOfCards myDeckOfCards = new DeckOfCards();
                myDeckOfCards.shuffle();

                return myDeckOfCards;
            }


            public Blackjack(int score, Card cards[])
            {
                this.score = score;
                this.cards = cards;
            }

            public Card deal(DeckOfCards myDeckOfCards)
            {
                    dealc = myDeckOfCards.dealCard();

                return dealc;
            }
            
            public int getScore()
            {
                return score;
            }

            public Card getCard(int i)
            {
               
                return cards[i];
            }

            public Card setCard(Card hand, int k)
            {

                cards[k] = hand;

                return cards[k];
            }

            public int setScore(Card[][] dealc,int i,int j)
            {
                
                switch(dealc[i][j].face.toString())
                {
                    case "Ace":
                        if(score <= 10)
                        {
                            score = score + 11;
                        }
                        else
                        {
                            score = score + 1;
                        }break;

                    case "Deuce":
                    score = score + 2;
                    break;

                    case "Three":
                    score = score + 3;
                    break;

                    case "Four":
                    score = score + 4;
                    break;

                    case "Five":
                    score = score + 5;
                    break;
                    
                    case "Six":
                    score = score + 6;
                    break;

                    case "Seven":
                    score = score + 7;
                    break;

                    case "Eight":
                    score = score + 8;
                    break;

                    case "Nine":
                    score = score + 9;
                    break;

                    case "Ten":
                    score = score + 10;
                    break;

                    case "Jack":
                    score = score + 10;
                    break;

                    case "Queen":
                    score = score + 10;
                    break;

                    case "King":
                    score = score + 10;
                    break;

                    default:
                    break;

                }
                return score;             
            }

            public int zeroScore()
            {
                score = 0;
                
                return score;
            }
    
}

