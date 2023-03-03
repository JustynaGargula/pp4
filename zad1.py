import queue

# podpunkt 1
def cenaNetto(cenaBrutto, podatek):
    # podatek podany w procentach np 23 (%)
    return cenaBrutto*(1-podatek/100)
print(cenaNetto(100,23),"\n")

# podpunkt 2
fifo = queue.Queue()            # fifo - first in first out
for i in [6,3,7,2,0]:
    fifo.put(i)
for i in range(5):
    print(fifo.get(i))
print("")

# podpunkt 3
f = open("plik1.txt", "a")
def procedura(tekst):
    f.write("\n"+tekst)

procedura("Ala ma kota")
procedura("Aneta posiada chomika")
f.close()

# podpunkt 4
class Student:
    def __init__(self, imie, nazwisko):
        self.imie = imie
        self.nazwisko = nazwisko
    def __str__(self):
        return self.imie+" "+self.nazwisko

class Zajecia:
    def __init__(self):
        self.studenci = []

    def zapisz_Studenta(self, student):
        if len(self.studenci)>=10:
            print("Brak miejsc na tych zajeciach.")
        else:
            self.studenci.append(student)
            print("Zapisano studenta: "+student.__str__())


z = Zajecia()
s1 = Student("Anna", "Lewandowska")
z.zapisz_Studenta(s1)
s2 = Student("Alicja", "Nowak")
z.zapisz_Studenta(s2)