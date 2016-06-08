from NewDataGenerator import Product
from termcolor import colored, cprint
import NewDataGenerator
#
# __rodzaj = 0
# __waga = 0
# __objetosc = 0
# __extra = 0
# __polka = 0
class AnswerAndLearningData:
    __to_predict = []
    __learn_features = []
    __learn_labels = []
    __answer = ""

    def __init__(self, product):
        self.__to_predict = product
        self.__learn_features, self.__learn_labels = self.generate_learn_product()
        self.__answer = self.generate_answer()

    def generate_learn_product(self):
        features = []
        labels = []
        for i in range(1,6):
            w = self.__to_predict[0]
            f = self.__to_predict[1] + i
            tp = self.__to_predict[2] + i
            fl = self.__to_predict[3]
            productPlus = Product(w, f, tp, fl)
            if productPlus.get_polka() != None:
                features.append([productPlus.get_rodzaj(),
                                 productPlus.get_waga(),
                                 productPlus.get_objetosc(),
                                 productPlus.get_extra()])
                labels.append(productPlus.get_polka())
            else:
                print(colored("[WARNING]",'yellow'),
                      colored("Generated learning product is NONE\t",'grey') + productPlus.print_error())
            w = self.__to_predict[0]
            f = self.__to_predict[1] - i
            tp = self.__to_predict[2] - i
            fl = self.__to_predict[3]
            productMinus = Product(w, f, tp, fl)
            if productMinus.get_polka() != None:
                features.append([productMinus.get_rodzaj(),
                                 productMinus.get_waga(),
                                 productMinus.get_objetosc(),
                                 productMinus.get_extra()])
                labels.append(productMinus.get_polka())
            else:
                print(colored("[WARNING]", 'yellow'),
                      colored("Generated learning product is NONE\t", 'grey') + productMinus.print_error())
        return features, labels

    def generate_answer(self):
        return Product(self.__to_predict[0],
                       self.__to_predict[1],
                       self.__to_predict[2],
                       self.__to_predict[3]).get_polka()

    def get_to_predict(self):
        return self.__to_predict

    def get_features(self):
        return self.__learn_features

    def get_labels(self):
        return self.__learn_labels

    def get_answer(self):
        return self.__answer
