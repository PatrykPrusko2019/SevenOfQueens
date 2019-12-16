SEVEN OF QUEENS on a chessboard:

/**
 *The program shows in 63 attempts how many times the Queen's figure can appear on the chessboard,
 *  so that none can capture another Queen's figure.
 *
 *  Queen figure -> 8
 *  the area the queen can move in -> 1
 *  free fields -> 0
 *
 *  Example of two pieces on a chessboard:
 *
 *  8 1 1 1 1 1 1 1
 *  1 1 0 0 0 0 0 0
 *  1 0 1 0 0 0 0 0
 *  1 0 0 1 0 0 0 0
 *  1 0 0 0 1 0 0 0
 *  1 0 0 0 0 1 0 0
 *  1 0 0 0 0 0 1 0
 *  1 0 0 0 0 0 0 1
 *
 *  The queen's field on the board is [0] [0] = 8.
 *  Number of fields the queen can move on -> 22
 *
 *  next queen on the chessboard:
 *
 *  8 1 1 1 1 1 1 1
 *  1 1 1 1 1 1 8 1
 *  1 0 1 0 0 1 1 1
 *  1 0 0 1 1 0 1 0
 *  1 0 0 1 1 0 1 0
 *  1 0 1 0 0 1 1 0
 *  1 1 0 0 0 0 1 0
 *  1 0 0 0 0 0 1 1
 *
 *
 *  The queen's field on the board is [1] [6] = 8.
 *  Number of fields the queen can move on -> 24
 *
 *  It starts with a random field, and then searches according to the algorithm for
 *  the field that has the lowest number of moves for a given queen, e.g. 22 number.
 *  Then, every attempt attempts to select all boxes 1 or 8. e.g .:
 *
 *  8 1 1 1 1 1 1 1
 *  1 1 1 1 8 1 1 1
 *  1 1 1 1 1 1 1 8
 *  1 1 1 1 1 1 1 1
 *  1 1 1 1 1 1 8 1
 *  1 1 8 1 1 1 1 1
 *  1 1 1 1 1 8 1 1
 *  1 8 1 1 1 1 1 1
 */
 
 
 
