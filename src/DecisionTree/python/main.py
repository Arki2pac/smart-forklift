from Prepare import AnswerAndLearningData
from sklearn.externals.six import StringIO
from termcolor import colored, cprint
from sklearn import tree
from sklearn import preprocessing
import DataGenerator
import pydotplus
import numpy


class DecisionTree:
    __to_predict = None
    __features_name = None
    __clf = None
    __data_generator = None
    __generated_data = None
    __magic_object = None
    __label = None
    __label_after_learn = None

    def __init__(self, to_predict, raport):
        # Set to predict
        self.__to_predict = to_predict
        # features name
        self.__features_name = ['waga', 'spożywczy', 'tempPrzech', 'flammability']
        # multi-class classification on a dataset.
        self.__clf = tree.DecisionTreeClassifier()
        # Generate data
        self.__data_generator = DataGenerator.Generate_data()
        # Get generated data
        self.__generated_data = self.__data_generator.get_data()

        # Generate proper answer and learning data
        self.__magic_object = AnswerAndLearningData(to_predict)

        # Predict label with tree
        self.__label = self.predict_label()
        # Learn and predict
        self.__label_after_learn = self.learn_and_predict()

        # Generate report
        if raport:
            self.generate_report(self.__label, self.__label_after_learn)


    def predict_label(self):
        features = self.__generated_data[0]
        labels = self.__generated_data[1]
        clf = self.__clf.fit(features, labels)
        predicted_label = clf.predict(self.__to_predict)
        # Export tree to PDF
        self.export_graph(clf,labels,"tree_without_learning")
        return predicted_label[0]

    def learn_and_predict(self):
        features = self.__generated_data[0] + self.__magic_object.get_features()
        labels = self.__generated_data[1] + self.__magic_object.get_labels()
        try:
            clf = self.__clf.fit(features, labels)
        except TypeError:
            print(self.__magic_object.get_features())
            print(self.__magic_object.get_labels())
        predicted_label = clf.predict(self.__to_predict)
        # Export tree to PDF
        self.export_graph(clf, labels, "tree_with_learning")
        return predicted_label[0]

    def export_graph(self, clf, labels, file_name):
        dot_data = StringIO()
        tree.export_graphviz(clf,
                             out_file=dot_data,
                             feature_names=self.__features_name,
                             class_names=labels,
                             filled=True, rounded=True,
                             impurity=False)
        graph = pydotplus.graph_from_dot_data(dot_data.getvalue())
        graph.write_pdf('{}.pdf'.format(file_name))

    def generate_report(self, label, label_with_learn):
        print("========== DATA ========== ")
        print(
            "Base:\n\tFeatures: {}\n\tLabels: {}".format(len(self.__generated_data[0]), len(self.__generated_data[1])))
        print("With learn({},{}):\n\tFeatures: {}\n\tBase Labels: {}".format(len(self.__magic_object.get_features()),
                                                                             len(self.__magic_object.get_labels()),
                                                                             len(self.__generated_data[0]) +
                                                                             len(self.__magic_object.get_features()),
                                                                             len(self.__generated_data[1]) +
                                                                             len(self.__magic_object.get_labels())))

        print("========== RESULT ========== ")
        print("Base Label: {}".format(self.__magic_object.get_answer()))
        print("Predicted label: {}".format(label))
        print("Predicted label after learning: {}".format(label_with_learn))
        if self.__magic_object.get_answer() == label:
            print("Status before learning: " + DataGenerator.OKGREEN + "OK" + DataGenerator.ENDC)
        else:
            print("Status before learning: " + DataGenerator.FAIL + "FAIL" + DataGenerator.ENDC)
        if self.__magic_object.get_answer() == label_with_learn:
            print("Status after learning: " + DataGenerator.OKGREEN + "OK" + DataGenerator.ENDC)
        else:
            print("Status after learning: " + DataGenerator.FAIL + "FAIL" + DataGenerator.ENDC)

    def get_result(self):
        return (self.__to_predict, self.__magic_object.get_answer(), self.__label, self.__label_after_learn)


# waga', 'spożywczy(0,1)', 'tempPrzech', 'łatwopalność(0,1)
# dt = DecisionTree([850, 1, 14, 0], True)
# result = dt.get_result()
# print(result)





tests = 1
current = 0
ok = 0
fail = 0
after_fail = 0
after_ok = 0
while current != tests:
    product = DataGenerator.Test_product()
    if product.get_place() != None:
        current += 1
        dt = DecisionTree([product.get_weight(),
                           product.get_food(),
                           product.get_temperature(),
                           product.get_flammability()], True).get_result()
        if dt[1] == dt[2]:
            ok += 1
        else:
            fail += 1
        if dt[1] == dt[3]:
            after_ok += 1
        else:
            after_fail += 1
text = "{} {} {} {}".format(ok,fail,after_ok,after_fail)

print("RESULT: " + colored(text,'green'))
