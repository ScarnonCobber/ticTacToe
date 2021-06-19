Tic Tac Toe game. Lets the user choose which token to play (Using X and M because hard to distinguish
0 and O as game is displayed in text currently.

Currently user always goes first and there is no 'AI' as the CPU just choses any available position without
care for possible winning position.

User enters selection, token is stored in an array purely for representing the board, and an entry added 
in a  secondarray to keep track of what squares have been used and which player has used it. 
When CPU picks a random number it checks if that position has already been claimed, otherwise updates array 
to claim square. Im using 4 for the user and 7 for the CPU, and when the program checks if the game has been 
won it looks for a row/colum/diagonal containing all 4s or 7s.

I certain this could be done in a single char array and comparing chars but I used this design as dealing 
the comparison of ints is easier for my current knowlege level.

AI, graphical interface and streamlining code to come.

Ben Alias 19/6/2021