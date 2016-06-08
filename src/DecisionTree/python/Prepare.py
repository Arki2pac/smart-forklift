from DataGenerator import Product
from termcolor import colored, cprint
import DataGenerator


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
            w = self.__to_predict[0] + i
            f = self.__to_predict[1]
            tp = self.__to_predict[2] + i
            fl = self.__to_predict[3]
            productPlus = Product(w, f, tp, fl)
            if productPlus.get_place() != None:
                features.append([productPlus.get_weight(),
                                 productPlus.get_food(),
                                 productPlus.get_temperature(),
                                 productPlus.get_flammability()])
                labels.append(productPlus.get_place())
            else:
                print(colored("[WARNING]",'yellow'),
                      colored("Generated learning product is NONE\t",'grey') + productPlus.print_error())
            w = self.__to_predict[0] - i
            f = self.__to_predict[1]
            tp = self.__to_predict[2] - i
            fl = self.__to_predict[3]
            productMinus = Product(w, f, tp, fl)
            if productMinus.get_place() != None:
                features.append([productMinus.get_weight(),
                                 productMinus.get_food(),
                                 productMinus.get_temperature(),
                                 productMinus.get_flammability()])
                labels.append(productMinus.get_place())
            else:
                print(colored("[WARNING]", 'yellow'),
                      colored("Generated learning product is NONE\t", 'grey') + productMinus.print_error())
        return features, labels

    def generate_answer(self):
        return Product(self.__to_predict[0],
                       self.__to_predict[1],
                       self.__to_predict[2],
                       self.__to_predict[3]).get_place()

    def get_to_predict(self):
        return self.__to_predict

    def get_features(self):
        return self.__learn_features

    def get_labels(self):
        return self.__learn_labels

    def get_answer(self):
        return self.__answer
