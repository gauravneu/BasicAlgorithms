To build DFA for pattern A B A B A C


0 --- A ---> 1 --- B ---> 2 --- A ---> 3 --- B ---> 4 --- A ---> 5 --- C ---> 6

when mismatch --> from x column, we will which state we will be in after mismatch.
To update x, it demonstrates where the machine would be if it is ran at one position shifted over