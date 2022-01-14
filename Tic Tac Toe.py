'''
Array with board[i][j]
Print an empty board
Function takes in two variables, i and j, player inputs row and column
i = row
j = column
TODO:
Add game conclusion from ties (complete(12/11/2021))
'''

board = [" "," "," "],[" "," "," "],[" "," "," "]
def printBoard():
	print(board[0][0] + "|" + board[0][1] + "|" + board[0][2])
	print("=====")
	print(board[1][0] + "|" + board[1][1] + "|" + board[1][2])
	print("=====")
	print(board[2][0] + "|" + board[2][1] + "|" + board[2][2])

def play(row, column, turns):
	if turns == 0:
		board[int(row)][int(column)] = "X"
	if turns == 1:
		board[int(row)][int(column)] = "O"

def playerInput():
	turns = 0
	while True:
		playerinput = (input("Player 1 input two numbers seperated by a space. First number is the row and second is the column: ")).rstrip().split()
		if 0 <= int(playerinput[0]) <= 2 and 0 <= int(playerinput[1]) <= 2 and board[int(playerinput[0])][int(playerinput[1])] == " ":
			break
		if int(playerinput[0]) < 0 or int(playerinput[0]) > 2 or int(playerinput[1]) < 0 or int(playerinput[1]) > 2:
			print("Please enter numbers from zero to two!")
		else:
			print("There is already an X or O there! Please try again.")
	play(playerinput[0],playerinput[1],turns)
	printBoard()
	checkWinner()
	turns = 1
	while True:
		playerinput = (input("Player 2 input two numbers seperated by a space. First number is the row and second is the column: ")).rstrip().split()
		if board[int(playerinput[0])][int(playerinput[1])] == " ":
			break
		if int(playerinput[0]) < 0 or int(playerinput[0]) > 2 or int(playerinput[1]) < 0 or int(playerinput[1]) > 2:
			print("Please enter numbers from zero to two!")
		else:
			print("There is already an X or O there! Please try again.")
	play(playerinput[0],playerinput[1],turns)
	printBoard()
	checkWinner()

def xIsWinner():
	print("Player 1 is the winner!")
	exit()

def OIsWinner():
	print("Player 2 is the winner!")
	exit()

def tie():
	print("There is no winner! Its a tie!")
	exit()

def checkWinner():
	if board[1][1] == "X":
		if board[0][0] == "X" and board[2][2] == "X":
			xIsWinner()
		if board[0][1] == "X" and board[2][1] == "X":
			xIsWinner()
		if board[0][2] == "X" and board[2][2] == "X":
			xIsWinner()
		if board[1][0] == "X" and board[1][2] == "X":
			xIsWinner()
	if board[0][0] == "X":
		if board[0][1] == "X" and board[0][2] == "X":
			xIsWinner()
		if board[1][0] == "X" and board[2][0] == "X":
			xIsWinner()
	if board[2][2] == "X":
		if board[2][0] == "X" and board[2][1] == "X":
			xIsWinner()
		if board[0][2] == "X" and board[1][2] == "X":
			xIsWinner()
	if board[1][1] == "O":
		if board[0][0] == "O" and board[2][2] == "O":
			OIsWinner()
		if board[0][1] == "O" and board[2][1] == "O":
			OIsWinner()
		if board[0][2] == "O" and board[2][2] == "O":
			OIsWinner()
		if board[1][0] == "O" and board[1][2] == "O":
			OIsWinner()
	if board[0][0] == "O":
		if board[0][1] == "O" and board[0][2] == "O":
			OIsWinner()
		if board[1][0] == "O" and board[2][0] == "O":
			OIsWinner()
	if board[2][2] == "O":
		if board[2][0] == "O" and board[2][1] == "O":
			OIsWinner()
		if board[0][2] == "O" and board[1][2] == "O":
			OIsWinner()
	if not any(' ' in sublist for sublist in board):
		tie()




print("Welcome to Tic Tac Toe! The first player will be X and the second player will be O.")
while True:
	playerInput()