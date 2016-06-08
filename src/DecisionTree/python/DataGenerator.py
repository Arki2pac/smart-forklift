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
    __weight = 0
    __food = 0
    __temperature = 0
    __flammability = 0
    __place = ""

    def __init__(self, weight, food, temperature, flammability):
        self.__weight = weight
        self.__food = food
        self.__temperature = temperature
        self.__flammability = flammability
        self.__place = self.generate_place()

    def error_check(self):
        if self.get_food() == 1 and self.get_flammability() == 1:
            return False
        elif self.get_flammability() == 1 and self.get_temperature() >= 25:
            return False
        else:
            return True

    def generate_place(self):
        place = ""
        sectors = ['C','D']
        if self.error_check():
            if self.__temperature <= 0:
                place += "A"
                place += self.generate_helper()
                return place
            elif self.__temperature > 0:
                if self.__food == 1:
                    place += "B"
                    place += self.generate_helper()
                    return place
                else:
                    temp = self.generate_helper()
                    if "TN" in temp:
                        place += "C" + temp
                    elif "NT" in temp:
                        place += "D" + temp
                    else: place += random.choice(sectors) + temp
                    return place
        else:
            print(colored("[ERROR]",'red'), colored(" Data check ended with FAIL\t",'grey') + self.print_error())

    def generate_helper(self):
        place = ""
        if self.__temperature <= 0:
            place += self.weight_helper() + "NN"
            return place
        elif self.__temperature > 0 and self.__temperature < 15:
            place += self.weight_helper() + "NN"
            return place
        elif self.__temperature >= 15 and self.__temperature < 25:
            if self.__flammability == 1:
                place += self.weight_helper() + "NN"
                return place
            else:
                place += self.weight_helper() + "NT"
                return place
        elif self.__temperature >= 25 and self.__temperature <= 28:
            if self.__flammability == 1:
                place += self.weight_helper() + "NN"
                return place
            else:
                place += self.weight_helper() + "TN"
                return place
        elif self.__temperature > 28:
            place += self.weight_helper() + "TT"
            return place
        else:
            place = "ERROR " + self.to_string()
            return place

    def weight_helper(self):
        if self.__weight <= 20:
            return "1"
        elif self.__weight > 20 and self.__weight <= 100:
            return "2"
        elif self.__weight > 100 and self.__weight <= 500:
            return "3"
        else:
            return "4"

    def get_weight(self):
        return self.__weight

    def get_food(self):
        return self.__food

    def get_temperature(self):
        return self.__temperature

    def get_flammability(self):
        return self.__flammability

    def get_place(self):
        return self.__place

    def to_string(self):
        return "{}, {}, {}, {}, {};\n".format(self.__weight,
                                              self.__food,
                                              self.__temperature,
                                              self.__flammability,
                                              self.__place)

    def print_error(self):
        return "Weight: {}, Food: {}, Temperature: {}, Flammability: {}, Place: {} " \
            .format(self.__weight,
                    self.__food,
                    self.__temperature,
                    self.__flammability,
                    self.__place)


class Food(Product):
    def __init__(self):
        weight = random.randint(1, 1000)
        food = 1
        temperature = random.randint(-10, 25)
        flammability = 0
        super(Food, self).__init__(weight, food, temperature, flammability)


class Non_food(Product):
    def __init__(self):
        weight = random.randint(1, 1000)
        food = 0
        temperature = random.randint(10, 35)
        flammability = 0 #random.randint(0 ,1)
        super(Non_food, self).__init__(weight, food, temperature, flammability)


class Dangerous(Product):
    def __init__(self):
        weight = random.randint(1, 1000)
        food = 0
        temperature = random.randint(10, 15)
        flammability = 1
        super(Dangerous, self).__init__(weight, food, temperature, flammability)


class Test_product(Product):
    def __init__(self):
        weight = random.randint(1, 1000)
        food = random.randint(0, 1)
        temperature = random.randint(-10, 40)
        flammability = random.randint(0, 1)
        super(Test_product, self).__init__(weight, food, temperature, flammability)


class Generate_data:
    __data = None

    def __init__(self):
        food_list = self.generate_food()
        non_food = self.generate_non_food()
        dangerous = self.generate_dangerous()
        self.__data = (food_list[0] + non_food[0] + dangerous[0],
                       food_list[1] + non_food[1] + dangerous[1])
        self.export_to_file(food_list[2] + non_food[2] + dangerous[2])

    def export_to_file(self, list):
        with open('data.txt', 'w') as file:
            for element in list:
                file.write(element)
        file.close()

    def generate_food(self):
        food_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 150):
            new_food = Food()
            place = new_food.get_place()
            if place != None:
                export.append(new_food.to_string())
                food_list.append([new_food.get_weight(),
                                  new_food.get_food(),
                                  new_food.get_temperature(),
                                  new_food.get_flammability()])
                labels.append(new_food.get_place())

        return (food_list, labels, export)

    def generate_non_food(self):
        non_food_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 150):
            new_food = Non_food()
            place = new_food.get_place()
            if place != None:
                export.append(new_food.to_string())
                non_food_list.append([new_food.get_weight(),
                                      new_food.get_food(),
                                      new_food.get_temperature(),
                                      new_food.get_flammability()])
                labels.append(new_food.get_place())

        return (non_food_list, labels, export)

    def generate_dangerous(self):
        dangerous_list = []
        labels = []
        export = []
        for _ in itertools.repeat(None, 150):
            new_dangerous = Dangerous()
            place = new_dangerous.get_place()
            if place != None:
                export.append(new_dangerous.to_string())
                dangerous_list.append([new_dangerous.get_weight(),
                                       new_dangerous.get_food(),
                                       new_dangerous.get_temperature(),
                                       new_dangerous.get_flammability()])
                labels.append(new_dangerous.get_place())

        return (dangerous_list, labels, export)

    def get_data(self):
        return self.__data

    def check(self, product):
        p = Product(product[0], product[1], product[2], product[3])
        print("Check result: " + p.get_place())









