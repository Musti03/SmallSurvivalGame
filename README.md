# SmallSurvivalGame

Small Survival Game with the goal to survive with card drawing and crafting.

How to play:

There are three phases : The first phase is drawing cards. You can draw an resource, rescue or a animal. When you draw an resource you are safety. But if you draw an animal you are under danger. And if you draw an catastrophe you lose your resources (If they are not in the hut). This phase repeats every turn as soon the player has not won or lost.

Draw resources After you draw a resources you are able to build some tools. For example you can build a axe with hepls you to defend against a animal. Or you can build a hut that saves you (only 5) resources from the thunderstorm. But if you build a rescue (sailingkraft, hangglider, steamboat or ballon). But before you can build a ballon or steamboat you need a fireplace.

Draw Animal

If the player draws a card from the Animals category, he must roll the die and lose where appropriate, all of its resources. Except for five resources built in it Hut had previously been brought to safety. Here he uses the 4-sided cube the spider, the 6-sided with the snake and the 8-sided with the tiger. In order to win and to save his resources, the player has to make 2 or greater on a spider, in the case of a snake a number of eyes really greater than 3, in the case of a tiger a number of eyes really greater than 4 roll the dice. In addition to the number of eyes, there can be a bonus of 2 (if you have an ax) or 1 (if you have a club), which is added to the number of dice rolled. Here only one tool (ax or club) may be used. Here will automatically always the stronger tool (Axe) be used. A builted tool remain the player for the game.

Draw catastrophe If the player draws the card from the catastrophe category, he loses his fireplace and all of his collected and already drawn cards (resources). With exception of the five resources secured in the shack. Items that have been destroyed by the storm can be rebuilt with new available resources. But they can only be built once in a single one Game.
Commands:

<> ignore this. It is just be used to show the commands.

start
cards = initialize the 64 cards from the game for example (wood, metal, plastic, spider, snake, tiger, thunderstorm, ...)
Here are the 64 cards: Ressourcen – 16 × wood – 16 × metal – 16 × plastic • Tiere – 5 × spider – 5 × snake – 5 × tiger • Katastrophe – 1 × thunderstorm

draw
After the draw they are 3 phases.

1.Scavenge (draw or build) 2.Encounter (defend against animal) 3.Endeavor (try to rescue)

If they are no more cards the player lose the game.

list-resources It lists the drawen resources for example: wood metal ... or it is "EMPTY"

build

x =

Tools – (axe): 3 × metal – (club) 3 × wood Constructions – (shack): 2 × wood, 1 × metal, 2 × plastic – (fireplace): 3 × wood, 1 × metal Rescue – (sailingraft): 4 × wood, 2 × metal, 2 × plastic – (hangglider): 2 × wood, 2 × metal, 4 × plastic – (steamboat): 6 × metal, 1 × plastic – (ballon): 1 × wood, 6 × plastic

list-buildings It lists the crafted objects.

build? It showes the crafted objects that can be built with the drawen resources.

rollDx

x = Here you can choose the typ of the dice (4,6 or 8) But you can just use the dice that is allowed for example 6 for sailingkraft or hangglider. Or for the spider the number 4.

y = is the solution of the rolling. (The user can choose what the player have roll. It can be used to control the game. But if you will you can change that)

reset It reset the game. After than you can start a new game.
