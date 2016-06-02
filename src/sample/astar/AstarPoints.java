package sample.astar;

import java.util.Map;

/**
 * Created by Arkadiusz Chrobak on 08.05.2016.
 */
public class AstarPoints {
    private int X;
    private int Y;

    public AstarPoints() {
        this(0,0);
    }
    public AstarPoints(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    // public String getXY() { return (X + ";" + Y); }
    public void setX(int X) {
        this.X = X;
    }
    public void setY(int Y) {
        this.Y = Y;
    }

    public static void prepareMultiplePoints(Map<Integer, AstarPoints> multiplePoints) {
        multiplePoints.put(0, new AstarPoints(110, 0));
        multiplePoints.put(1, new AstarPoints(110, 35));
        multiplePoints.put(2, new AstarPoints(110, 70));
        multiplePoints.put(3, new AstarPoints(110, 147));
        multiplePoints.put(4, new AstarPoints(110, 178));
        multiplePoints.put(5, new AstarPoints(110, 220));
        multiplePoints.put(6, new AstarPoints(110, 273));
        multiplePoints.put(7, new AstarPoints(110, 310));
        multiplePoints.put(8, new AstarPoints(110, 357));
        multiplePoints.put(9, new AstarPoints(110, 402));
        multiplePoints.put(10, new AstarPoints(110, 445));
        multiplePoints.put(11, new AstarPoints(110, 500));
        multiplePoints.put(12, new AstarPoints(110, 552));
        multiplePoints.put(13, new AstarPoints(110, 604));
        multiplePoints.put(14, new AstarPoints(110, 639));
        multiplePoints.put(15, new AstarPoints(110, 674));


        multiplePoints.put(16, new AstarPoints(150, 0));
        multiplePoints.put(17, new AstarPoints(150, 35));
        multiplePoints.put(18, new AstarPoints(150, 70));
        multiplePoints.put(19, new AstarPoints(150, 147));
        multiplePoints.put(20, new AstarPoints(150, 178));
        multiplePoints.put(21, new AstarPoints(150, 220));
        multiplePoints.put(22, new AstarPoints(150, 273));
        multiplePoints.put(23, new AstarPoints(150, 310));
        multiplePoints.put(24, new AstarPoints(150, 357));
        multiplePoints.put(25, new AstarPoints(150, 402));
        multiplePoints.put(26, new AstarPoints(150, 445));
        multiplePoints.put(27, new AstarPoints(150, 500));
        multiplePoints.put(28, new AstarPoints(150, 552));
        multiplePoints.put(29, new AstarPoints(150, 604));
        multiplePoints.put(30, new AstarPoints(150, 639));
        multiplePoints.put(31, new AstarPoints(150, 674));


        multiplePoints.put(32, new AstarPoints(190, 0));
        multiplePoints.put(33, new AstarPoints(190, 35));
        multiplePoints.put(34, new AstarPoints(190, 70));
        multiplePoints.put(35, new AstarPoints(190, 147));
        multiplePoints.put(36, new AstarPoints(190, 178));
        multiplePoints.put(37, new AstarPoints(190, 220));
        multiplePoints.put(38, new AstarPoints(190, 273));
        multiplePoints.put(39, new AstarPoints(190, 310));
        multiplePoints.put(40, new AstarPoints(190, 357));
        multiplePoints.put(41, new AstarPoints(190, 402));
        multiplePoints.put(42, new AstarPoints(190, 445));
        multiplePoints.put(43, new AstarPoints(190, 500));
        multiplePoints.put(44, new AstarPoints(190, 552));
        multiplePoints.put(45, new AstarPoints(190, 604));
        multiplePoints.put(46, new AstarPoints(190, 639));
        multiplePoints.put(47, new AstarPoints(190, 674));


        multiplePoints.put(48, new AstarPoints(240, 0));
        multiplePoints.put(49, new AstarPoints(240, 35));
        multiplePoints.put(50, new AstarPoints(240, 70));
        multiplePoints.put(51, new AstarPoints(240, 147));
        multiplePoints.put(52, new AstarPoints(240, 178));
        multiplePoints.put(53, new AstarPoints(240, 220));
        multiplePoints.put(54, new AstarPoints(240, 273));
        multiplePoints.put(55, new AstarPoints(240, 310));
        multiplePoints.put(56, new AstarPoints(240, 357));
        multiplePoints.put(57, new AstarPoints(240, 402));
        multiplePoints.put(58, new AstarPoints(240, 445));
        multiplePoints.put(59, new AstarPoints(240, 500));
        multiplePoints.put(60, new AstarPoints(240, 552));
        multiplePoints.put(61, new AstarPoints(240, 604));
        multiplePoints.put(62, new AstarPoints(240, 639));
        multiplePoints.put(63, new AstarPoints(240, 674));


        multiplePoints.put(64, new AstarPoints(265, 0));
        multiplePoints.put(65, new AstarPoints(265, 35));
        multiplePoints.put(66, new AstarPoints(265, 70));
        multiplePoints.put(67, new AstarPoints(265, 147));
        multiplePoints.put(68, new AstarPoints(265, 178));
        multiplePoints.put(69, new AstarPoints(265, 220));
        multiplePoints.put(70, new AstarPoints(265, 273));
        multiplePoints.put(71, new AstarPoints(265, 310));
        multiplePoints.put(72, new AstarPoints(265, 357));
        multiplePoints.put(73, new AstarPoints(265, 402));
        multiplePoints.put(74, new AstarPoints(265, 445));
        multiplePoints.put(75, new AstarPoints(265, 500));
        multiplePoints.put(76, new AstarPoints(265, 552));
        multiplePoints.put(77, new AstarPoints(265, 604));
        multiplePoints.put(78, new AstarPoints(265, 639));
        multiplePoints.put(79, new AstarPoints(265, 674));


        multiplePoints.put(80, new AstarPoints(315, 0));
        multiplePoints.put(81, new AstarPoints(315, 35));
        multiplePoints.put(82, new AstarPoints(315, 70));
        multiplePoints.put(83, new AstarPoints(315, 147));
        multiplePoints.put(84, new AstarPoints(315, 178));
        multiplePoints.put(85, new AstarPoints(315, 220));
        multiplePoints.put(86, new AstarPoints(315, 273));
        multiplePoints.put(87, new AstarPoints(315, 310));
        multiplePoints.put(88, new AstarPoints(315, 357));
        multiplePoints.put(89, new AstarPoints(315, 402));
        multiplePoints.put(90, new AstarPoints(315, 445));
        multiplePoints.put(91, new AstarPoints(315, 500));
        multiplePoints.put(92, new AstarPoints(315, 552));
        multiplePoints.put(93, new AstarPoints(315, 604));
        multiplePoints.put(94, new AstarPoints(315, 639));
        multiplePoints.put(95, new AstarPoints(315, 674));


        multiplePoints.put(96, new AstarPoints(355, 0));
        multiplePoints.put(97, new AstarPoints(355, 35));
        multiplePoints.put(98, new AstarPoints(355, 70));
        multiplePoints.put(99, new AstarPoints(355, 147));
        multiplePoints.put(100, new AstarPoints(355, 178));
        multiplePoints.put(101, new AstarPoints(355, 220));
        multiplePoints.put(102, new AstarPoints(355, 273));
        multiplePoints.put(103, new AstarPoints(355, 310));
        multiplePoints.put(104, new AstarPoints(355, 357));
        multiplePoints.put(105, new AstarPoints(355, 402));
        multiplePoints.put(106, new AstarPoints(355, 445));
        multiplePoints.put(107, new AstarPoints(355, 500));
        multiplePoints.put(108, new AstarPoints(355, 552));
        multiplePoints.put(109, new AstarPoints(355, 604));
        multiplePoints.put(110, new AstarPoints(355, 639));
        multiplePoints.put(111, new AstarPoints(355, 674));


        multiplePoints.put(112, new AstarPoints(395, 0));
        multiplePoints.put(113, new AstarPoints(395, 35));
        multiplePoints.put(114, new AstarPoints(395, 70));
        multiplePoints.put(115, new AstarPoints(395, 147));
        multiplePoints.put(116, new AstarPoints(395, 178));
        multiplePoints.put(117, new AstarPoints(395, 220));
        multiplePoints.put(118, new AstarPoints(395, 273));
        multiplePoints.put(119, new AstarPoints(395, 310));
        multiplePoints.put(120, new AstarPoints(395, 357));
        multiplePoints.put(121, new AstarPoints(395, 402));
        multiplePoints.put(122, new AstarPoints(395, 445));
        multiplePoints.put(123, new AstarPoints(395, 500));
        multiplePoints.put(124, new AstarPoints(395, 552));
        multiplePoints.put(125, new AstarPoints(395, 604));
        multiplePoints.put(126, new AstarPoints(395, 639));
        multiplePoints.put(127, new AstarPoints(395, 674));


        multiplePoints.put(128, new AstarPoints(425, 0));
        multiplePoints.put(129, new AstarPoints(425, 35));
        multiplePoints.put(130, new AstarPoints(425, 70));
        multiplePoints.put(131, new AstarPoints(425, 147));
        multiplePoints.put(132, new AstarPoints(425, 178));
        multiplePoints.put(133, new AstarPoints(425, 220));
        multiplePoints.put(134, new AstarPoints(425, 273));
        multiplePoints.put(135, new AstarPoints(425, 310));
        multiplePoints.put(136, new AstarPoints(425, 357));
        multiplePoints.put(137, new AstarPoints(425, 402));
        multiplePoints.put(138, new AstarPoints(425, 445));
        multiplePoints.put(139, new AstarPoints(425, 500));
        multiplePoints.put(140, new AstarPoints(425, 552));
        multiplePoints.put(141, new AstarPoints(425, 604));
        multiplePoints.put(142, new AstarPoints(425, 639));
        multiplePoints.put(143, new AstarPoints(425, 674));


        multiplePoints.put(144, new AstarPoints(470, 0));
        multiplePoints.put(145, new AstarPoints(470, 35));
        multiplePoints.put(146, new AstarPoints(470, 70));
        multiplePoints.put(147, new AstarPoints(470, 147));
        multiplePoints.put(148, new AstarPoints(470, 178));
        multiplePoints.put(149, new AstarPoints(470, 220));
        multiplePoints.put(150, new AstarPoints(470, 273));
        multiplePoints.put(151, new AstarPoints(470, 310));
        multiplePoints.put(152, new AstarPoints(470, 357));
        multiplePoints.put(153, new AstarPoints(470, 402));
        multiplePoints.put(154, new AstarPoints(470, 445));
        multiplePoints.put(155, new AstarPoints(470, 500));
        multiplePoints.put(156, new AstarPoints(470, 552));
        multiplePoints.put(157, new AstarPoints(470, 604));
        multiplePoints.put(158, new AstarPoints(470, 639));
        multiplePoints.put(159, new AstarPoints(470, 674));


        multiplePoints.put(160, new AstarPoints(515, 0));
        multiplePoints.put(161, new AstarPoints(515, 35));
        multiplePoints.put(162, new AstarPoints(515, 70));
        multiplePoints.put(163, new AstarPoints(515, 147));
        multiplePoints.put(164, new AstarPoints(515, 178));
        multiplePoints.put(165, new AstarPoints(515, 220));
        multiplePoints.put(166, new AstarPoints(515, 273));
        multiplePoints.put(167, new AstarPoints(515, 310));
        multiplePoints.put(168, new AstarPoints(515, 357));
        multiplePoints.put(169, new AstarPoints(515, 402));
        multiplePoints.put(170, new AstarPoints(515, 445));
        multiplePoints.put(171, new AstarPoints(515, 500));
        multiplePoints.put(172, new AstarPoints(515, 552));
        multiplePoints.put(173, new AstarPoints(515, 604));
        multiplePoints.put(174, new AstarPoints(515, 639));
        multiplePoints.put(175, new AstarPoints(515, 674));


        multiplePoints.put(176, new AstarPoints(550, 0));
        multiplePoints.put(177, new AstarPoints(550, 35));
        multiplePoints.put(178, new AstarPoints(550, 70));
        multiplePoints.put(179, new AstarPoints(550, 147));
        multiplePoints.put(180, new AstarPoints(550, 178));
        multiplePoints.put(181, new AstarPoints(550, 220));
        multiplePoints.put(182, new AstarPoints(550, 273));
        multiplePoints.put(183, new AstarPoints(550, 310));
        multiplePoints.put(184, new AstarPoints(550, 357));
        multiplePoints.put(185, new AstarPoints(550, 402));
        multiplePoints.put(186, new AstarPoints(550, 445));
        multiplePoints.put(187, new AstarPoints(550, 500));
        multiplePoints.put(188, new AstarPoints(550, 552));
        multiplePoints.put(189, new AstarPoints(550, 604));
        multiplePoints.put(190, new AstarPoints(550, 639));
        multiplePoints.put(191, new AstarPoints(550, 674));


        multiplePoints.put(192, new AstarPoints(580, 0));
        multiplePoints.put(193, new AstarPoints(580, 35));
        multiplePoints.put(194, new AstarPoints(580, 70));
        multiplePoints.put(195, new AstarPoints(580, 147));
        multiplePoints.put(196, new AstarPoints(580, 178));
        multiplePoints.put(197, new AstarPoints(580, 220));
        multiplePoints.put(198, new AstarPoints(580, 273));
        multiplePoints.put(199, new AstarPoints(580, 310));
        multiplePoints.put(200, new AstarPoints(580, 357));
        multiplePoints.put(201, new AstarPoints(580, 402));
        multiplePoints.put(202, new AstarPoints(580, 445));
        multiplePoints.put(203, new AstarPoints(580, 500));
        multiplePoints.put(204, new AstarPoints(580, 552));
        multiplePoints.put(205, new AstarPoints(580, 604));
        multiplePoints.put(206, new AstarPoints(580, 639));
        multiplePoints.put(207, new AstarPoints(580, 674));


        multiplePoints.put(208, new AstarPoints(625, 0));
        multiplePoints.put(209, new AstarPoints(625, 35));
        multiplePoints.put(210, new AstarPoints(625, 70));
        multiplePoints.put(211, new AstarPoints(625, 147));
        multiplePoints.put(212, new AstarPoints(625, 178));
        multiplePoints.put(213, new AstarPoints(625, 220));
        multiplePoints.put(214, new AstarPoints(625, 273));
        multiplePoints.put(215, new AstarPoints(625, 310));
        multiplePoints.put(216, new AstarPoints(625, 357));
        multiplePoints.put(217, new AstarPoints(625, 402));
        multiplePoints.put(218, new AstarPoints(625, 445));
        multiplePoints.put(219, new AstarPoints(625, 500));
        multiplePoints.put(220, new AstarPoints(625, 552));
        multiplePoints.put(221, new AstarPoints(625, 604));
        multiplePoints.put(222, new AstarPoints(625, 639));
        multiplePoints.put(223, new AstarPoints(625, 674));


        multiplePoints.put(224, new AstarPoints(670, 0));
        multiplePoints.put(225, new AstarPoints(670, 35));
        multiplePoints.put(226, new AstarPoints(670, 70));
        multiplePoints.put(227, new AstarPoints(670, 147));
        multiplePoints.put(228, new AstarPoints(670, 178));
        multiplePoints.put(229, new AstarPoints(670, 220));
        multiplePoints.put(230, new AstarPoints(670, 273));
        multiplePoints.put(231, new AstarPoints(670, 310));
        multiplePoints.put(232, new AstarPoints(670, 357));
        multiplePoints.put(233, new AstarPoints(670, 402));
        multiplePoints.put(234, new AstarPoints(670, 445));
        multiplePoints.put(235, new AstarPoints(670, 500));
        multiplePoints.put(236, new AstarPoints(670, 552));
        multiplePoints.put(237, new AstarPoints(670, 604));
        multiplePoints.put(238, new AstarPoints(670, 639));
        multiplePoints.put(239, new AstarPoints(670, 674));


        multiplePoints.put(240, new AstarPoints(705, 0));
        multiplePoints.put(241, new AstarPoints(705, 35));
        multiplePoints.put(242, new AstarPoints(705, 70));
        multiplePoints.put(243, new AstarPoints(705, 147));
        multiplePoints.put(244, new AstarPoints(705, 178));
        multiplePoints.put(245, new AstarPoints(705, 220));
        multiplePoints.put(246, new AstarPoints(705, 273));
        multiplePoints.put(247, new AstarPoints(705, 310));
        multiplePoints.put(248, new AstarPoints(705, 357));
        multiplePoints.put(249, new AstarPoints(705, 402));
        multiplePoints.put(250, new AstarPoints(705, 445));
        multiplePoints.put(251, new AstarPoints(705, 500));
        multiplePoints.put(252, new AstarPoints(705, 552));
        multiplePoints.put(253, new AstarPoints(705, 604));
        multiplePoints.put(254, new AstarPoints(705, 639));
        multiplePoints.put(255, new AstarPoints(705, 674));

    }
}