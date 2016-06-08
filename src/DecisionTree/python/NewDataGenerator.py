from termcolor import colored, cprint
import random
import itertools

FAIL = '\033[91m'
WARNING = '\033[93m'
OKGREEN = '\033[92m'
ENDC = '\033[0m'
HEADER = '\033[95m'
BOLD = '\033[1m'


class Product:
    __rodzaj = 0
    __waga = 0
    __objetosc = 0
    __extra = 0
    __polka = ""

    def __init__(self,rodzaj = None, waga = None, objetosc=None, extra = None):
        if rodzaj is None:
            self.__rodzaj = random.randint(1, 4)
        else: self.__rodzaj = rodzaj
        if waga is None:
            self.__waga = None
        else: self.__waga = waga
        if objetosc is None:
            self.__objetosc = random.randint(1, 100)
        else:
            self.__objetosc = objetosc
        if extra is None:
            self.__extra = None
        else: self.__extra = extra

        self.__polka = str(self.generate_polka())

    def chech_error(self):
        if self.__waga <= 0:
            return False
        elif self.__objetosc <=0:
            return False
        else:
            return True

    def generate_polka(self):
        if self.chech_error():
            if self.get_extra() == 1:
                return 4
            elif self.get_extra() == 2:
                return 1
            elif self.get_extra() == 3:
                return self.waga_rozmiar_helper()
            else:
                return None
        else:
            print(colored("[ERROR]", 'red'), colored(" Data check ended with FAIL\t", 'grey') + self.print_error())
            return None


    def waga_rozmiar_helper(self):
        if self.__waga <= 20:
            return 3
        elif self.__waga > 20:
            return 2
        else:
            return None

    def get_rodzaj(self):
        return self.__rodzaj

    def get_waga(self):
        return self.__waga

    def get_objetosc(self):
        return self.__objetosc

    def get_extra(self):
        return self.__extra

    def get_polka(self):
        return self.__polka

    def to_string(self):
        return "{}, {}, {}, {}, {};\n".format(self.__rodzaj,
                                              self.__waga,
                                              self.__objetosc,
                                              self.__extra,
                                              self.__polka)

    def print_error(self):
        return "rodzaj: {}, waga: {}, objetosc: {}, extra: {}, polka: {} " \
            .format(self.__rodzaj,
                    self.__waga,
                    self.__objetosc,
                    self.__extra,
                    self.__polka)


class Duze_i_ciezkie(Product):
    def __init__(self):
        waga = random.randint(20, 1000)
        extra = 3
        super(Duze_i_ciezkie, self).__init__(None,waga,None, extra)


class Male_i_lekkie(Product):
    def __init__(self):
        waga = random.randint(1, 19)
        extra = 3
        super(Male_i_lekkie, self).__init__(None,waga,None, extra)


class Latwopalne(Product):
    def __init__(self):
        waga = random.randint(1, 1000)
        extra = 1
        super(Latwopalne, self).__init__(None,waga,None, extra)


class Chlodne(Product):
    def __init__(self):
        waga = random.randint(1, 1000)
        extra = 2
        super(Chlodne, self).__init__(None,waga,None, extra)


class Test_product(Product):
    def __init__(self):
        waga = random.randint(1, 1000)
        extra = random.randint(1, 3)
        super(Test_product, self).__init__(None,waga,None, extra)


class Generate_data:
    __data = None

    def __init__(self):
        waga_list = self.generate_duze_i_ciezkie()
        non_waga = self.generate_male_i_lekkie()
        dangerous = self.generate_latwopalne()
        chlodne = self.generate_chlodne()
        self.__data = (waga_list[0] + non_waga[0] + dangerous[0] + chlodne[0],
                       waga_list[1] + non_waga[1] + dangerous[1] + chlodne[1])
        self.export_to_file(waga_list[2] + non_waga[2] + dangerous[2] + chlodne[2])

    def export_to_file(self, list):
        with open('data_new.txt', 'w') as file:
            for element in list:
                file.write(element)
        file.close()

    def generate_duze_i_ciezkie(self):
        waga_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 200):
            new_dIo = Duze_i_ciezkie()
            polka = new_dIo.get_polka()
            if polka != None:
                export.append(new_dIo.to_string())
                waga_list.append([new_dIo.get_rodzaj(),
                                  new_dIo.get_waga(),
                                  new_dIo.get_objetosc(),
                                  new_dIo.get_extra()])
                labels.append(new_dIo.get_polka())

        return (waga_list, labels, export)

    def generate_male_i_lekkie(self):
        non_waga_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 200):
            new_mIl = Male_i_lekkie()
            polka = new_mIl.get_polka()
            if polka != None:
                export.append(new_mIl.to_string())
                non_waga_list.append([new_mIl.get_rodzaj(),
                                      new_mIl.get_waga(),
                                      new_mIl.get_objetosc(),
                                      new_mIl.get_extra()])
                labels.append(new_mIl.get_polka())

        return (non_waga_list, labels, export)

    def generate_latwopalne(self):
        dangerous_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 200):
            new_latwopalne = Latwopalne()
            polka = new_latwopalne.get_polka()
            if polka != None:
                export.append(new_latwopalne.to_string())
                dangerous_list.append([new_latwopalne.get_rodzaj(),
                                       new_latwopalne.get_waga(),
                                       new_latwopalne.get_objetosc(),
                                       new_latwopalne.get_extra()])
                labels.append(new_latwopalne.get_polka())

        return (dangerous_list, labels, export)

    def generate_chlodne(self):
        dangerous_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 200):
            new_chlodne = Chlodne()
            polka = new_chlodne.get_polka()
            if polka != None:
                export.append(new_chlodne.to_string())
                dangerous_list.append([new_chlodne.get_rodzaj(),
                                       new_chlodne.get_waga(),
                                       new_chlodne.get_objetosc(),
                                       new_chlodne.get_extra()])
                labels.append(new_chlodne.get_polka())

        return (dangerous_list, labels, export)

    def get_data(self):
        return self.__data

    def check(self, product):
        p = Product(product[0], product[1], product[2], product[3])
        print("Check result: " + p.get_polka())
