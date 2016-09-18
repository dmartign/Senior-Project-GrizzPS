package edu.oakland.test;

//import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Stack;
import android.location.*;

        import static android.location.Location.distanceBetween;

/**
 *
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

public class GraphStuff2 {
    static int roomCode=4, roomCode2=12;
    static double totalDist=0, range=.000001, bearing=0.0;
    static IntersectionNode starto, starti, dest;

    // Indoor graph initialization - First Floor of DHE
    public static Stack<IntersectionNode> initializeIndoor(String start, String end) {
        totalDist=0;
        IntersectionList graph = new IntersectionList();

        // Nodes to form the graph data structure for indoor navigation
        Intersections dhe1 = new Intersections(1,42.67163813,-83.21609661);
        dhe1.setName("entrance");
        Intersections dhe2 = new Intersections(2,42.67163813,-83.21613818);
        dhe2.setName("stairs to second floor");
        Intersections dhe3 = new Intersections(3,42.67163715,-83.21615562);
        dhe3.setName("entrance to hall");
        Intersections dhe4 = new Intersections(4,42.67160165,-83.21615696);
        dhe4.setName("room 156");
        Intersections dhe5 = new Intersections(5,42.67155728,-83.21615964);
        dhe5.setName("room 155");//also room 155A
        Intersections dhe6 = new Intersections(6,42.67155629,-83.21619719);
        dhe6.setName("room 154");
        Intersections dhe7 = new Intersections(7,42.67155728,-83.21624011);
        dhe7.setName("room 152");
        Intersections dhe8 = new Intersections(8,42.67155629,-83.21625754);
        dhe8.setName("room 151");
        Intersections dhe9 = new Intersections(9,42.67155629,-83.21629375);
        dhe9.setName("room 152A");
        Intersections dhe10 = new Intersections(10,42.67155629,-83.21631119);
        dhe10.setName("room 149");
        Intersections dhe11 = new Intersections(11,42.67155728,-83.21633399);
        dhe11.setName("room 150");
        Intersections dhe12 = new Intersections(12,42.6715553,-83.21639299);
        dhe12.setName("room 148");
        Intersections dhe13 = new Intersections(13,42.67155629,-83.21641847);
        dhe13.setName("room 147");
        Intersections dhe14 = new Intersections(14,42.6715553,-83.21643323);
        dhe14.setName("room 146");
        Intersections dhe15 = new Intersections(15,42.67155629,-83.21649894);
        dhe15.setName("room 143");
        Intersections dhe16 = new Intersections(16,42.67155629,-83.21653917);
        dhe16.setName("corner");
        Intersections dhe17 = new Intersections(17,42.67153361,-83.21653917);
        dhe17.setName("room 144");
        Intersections dhe18 = new Intersections(18,42.671506,-83.21653917);
        dhe18.setName("room 142");
        Intersections dhe19 = new Intersections(19,42.67147839,-83.21653783);
        dhe19.setName("room 141");
        Intersections dhe20 = new Intersections(20,42.67144881,-83.21653783);
        dhe20.setName("room 140");
        Intersections dhe21 = new Intersections(21,42.67141824,-83.21653783);
        dhe21.setName("room 139");
        Intersections dhe22 = new Intersections(22,42.67139162,-83.21653783);
        dhe22.setName("room 138");
        Intersections dhe23 = new Intersections(23,42.67138373,-83.21653783);
        dhe23.setName("room 137");
        Intersections dhe24 = new Intersections(24,42.67138176,-83.21664378);
        dhe24.setName("stairs exit");
        Intersections dhe25 = new Intersections(25,42.67135218,-83.21662098);
        dhe25.setName("stairs to basement and second floor");
        Intersections dhe26 = new Intersections(26,42.67138373,-83.21668267);
        dhe26.setName("room 134");
        Intersections dhe27 = new Intersections(27,42.67138373,-83.2167457);
        dhe27.setName("room 133");
        Intersections dhe28 = new Intersections(28,42.67139261,-83.21674973);
        dhe28.setName("room 132");
        Intersections dhe29 = new Intersections(29,42.6714143,-83.21674705);
        dhe29.setName("room 135");
        Intersections dhe30 = new Intersections(30,42.67142021,-83.21674839);
        dhe30.setName("room 131");
        Intersections dhe31 = new Intersections(31,42.67144585,-83.21674973);
        dhe31.setName("room 130");
        Intersections dhe32 = new Intersections(32,42.67147543,-83.21674973);
        dhe32.setName("room 129");
        Intersections dhe33 = new Intersections(33,42.67150304,-83.21675107);
        dhe33.setName("room 128");
        Intersections dhe34 = new Intersections(34,42.67152079,-83.21676716);
        dhe34.setName("elevator");
        Intersections dhe35 = new Intersections(35,42.67155037,-83.21675241);
        dhe35.setName("room 127");
        Intersections dhe36 = new Intersections(36,42.6715553,-83.21675375);
        dhe36.setName("room 173");
        Intersections dhe37 = new Intersections(37,42.67155629,-83.21678326);
        dhe37.setName("room 126");
        Intersections dhe38 = new Intersections(38,42.6715553,-83.21683154);
        dhe38.setName("room 125");
        Intersections dhe39 = new Intersections(39,42.6715553,-83.21686506);
        dhe39.setName("room 123");
        Intersections dhe40 = new Intersections(40,42.6715553,-83.21687311);
        dhe40.setName("room 124");
        Intersections dhe41 = new Intersections(41,42.67155629,-83.21690932);
        dhe41.setName("room 122");
        Intersections dhe42 = new Intersections(42,42.6715553,-83.21694285);
        dhe42.setName("room 120");
        Intersections dhe43 = new Intersections(43,42.6715553,-83.21696699);
        dhe43.setName("room 121");
        Intersections dhe44 = new Intersections(44,42.67155629,-83.21699783);
        dhe44.setName("room 120A");
        Intersections dhe45 = new Intersections(45,42.67155629,-83.21700856);
        dhe45.setName("room 119");
        Intersections dhe46 = new Intersections(46,42.67155432,-83.2170327);
        dhe46.setName("room 118");
        Intersections dhe47 = new Intersections(47,42.6715553,-83.21707159);
        dhe47.setName("room 116");// also room 117
        Intersections dhe48 = new Intersections(48,42.67155728,-83.21711183);
        dhe48.setName("room 115");
        Intersections dhe49 = new Intersections(49,42.67158883,-83.21711451);
        dhe49.setName("room 113");
        Intersections dhe50 = new Intersections(50,42.67162038,-83.21711585);
        dhe50.setName("room 112");
        Intersections dhe51 = new Intersections(51,42.67164996,-83.21711585);
        dhe51.setName("room 111");
        Intersections dhe52 = new Intersections(52,42.67167462,-83.21711719);
        dhe52.setName("exit to HHS");
        Intersections dhe53 = new Intersections(53,42.6716756,-83.21717888);
        dhe53.setName("entrance to HHS");
        Intersections dhe54 = new Intersections(54,42.67171406,-83.21711719);
        dhe54.setName("room 110");
        Intersections dhe55 = new Intersections(55,42.67171307,-83.21711048);
        dhe55.setName("room 109");
        Intersections dhe56 = new Intersections(56,42.67171307,-83.21708098);
        dhe56.setName("room 107");
        Intersections dhe57 = new Intersections(57,42.67171307,-83.21707293);
        dhe57.setName("room 108");
        Intersections dhe58 = new Intersections(58,42.67171209,-83.21703672);
        dhe58.setName("room 105A");
        Intersections dhe59 = new Intersections(59,42.67171209,-83.21701527);
        dhe59.setName("room 106");
        Intersections dhe60 = new Intersections(60,42.67171307,-83.21698442);
        dhe60.setName("room 105");
        Intersections dhe61 = new Intersections(61,42.67171209,-83.2169643);
        dhe61.setName("room 104");
        Intersections dhe62 = new Intersections(62,42.67171209,-83.21692675);
        dhe62.setName("room 103");
        Intersections dhe63 = new Intersections(63,42.67171209,-83.21687177);
        dhe63.setName("room 103A");
        Intersections dhe64 = new Intersections(64,42.67171209,-83.21686372);
        dhe64.setName("room 102");
        Intersections dhe65 = new Intersections(65,42.67171209,-83.21683556);
        dhe65.setName("room 101");
        Intersections dhe66 = new Intersections(66,42.67168349,-83.21679533);
        dhe66.setName("stairs entrance");//??
        Intersections dhe67 = new Intersections(67,42.67171209,-83.21679398);
        dhe67.setName("hallway intersection");
        Intersections dhe68 = new Intersections(68,42.67161447,-83.2167913);
        dhe68.setName("men's bathroom");
        Intersections dhe69 = new Intersections(69,42.67159869,-83.21678594);
        dhe69.setName("room 172");
        Intersections dhe70 = new Intersections(70,42.67171406,-83.21673766); // stairs next to 171??
        dhe70.setName("stairs next to courtyard");
        Intersections dhe71 = new Intersections(71,42.67168546,-83.21669474);
        dhe71.setName("room 171");
        Intersections dhe72 = new Intersections(72,42.67168546,-83.21667463);
        dhe72.setName("room 170");
        Intersections dhe73 = new Intersections(73,42.67168546,-83.21662098);
        dhe73.setName("room 169");
        Intersections dhe74 = new Intersections(74,42.67168546,-83.21657941);
        dhe74.setName("room 168");// also room/lab 167
        Intersections dhe75 = new Intersections(75,42.67171011,-83.21649626);
        dhe75.setName("intersect");
        Intersections dhe76 = new Intersections(76,42.67163715,-83.21649894);
        dhe76.setName("room 145");
        Intersections dhe77 = new Intersections(77,42.67168645,-83.21652174);
        dhe77.setName("room 166");
        Intersections dhe78 = new Intersections(78,42.67171011,-83.216452);
        dhe78.setName("room 165");
        Intersections dhe79 = new Intersections(79,42.67171011,-83.21641982);
        dhe79.setName("room 164");
        Intersections dhe80 = new Intersections(80,42.67171011,-83.21640775);
        dhe80.setName("room 163A");
        Intersections dhe81 = new Intersections(81,42.67171011,-83.21635008);
        dhe81.setName("room 163");
        Intersections dhe82 = new Intersections(82,42.67171011,-83.21631119);
        dhe82.setName("room 162");
        Intersections dhe83 = new Intersections(83,42.67171011,-83.21629509);
        dhe83.setName("room 161");
        Intersections dhe84 = new Intersections(84,42.67170814,-83.21625888);
        dhe84.setName("room 160");
        Intersections dhe85 = new Intersections(85,42.67170913,-83.21623877);
        dhe85.setName("room 159A");
        Intersections dhe86 = new Intersections(86,42.67171011,-83.21619987);
        dhe86.setName("room 158");//also room 159
        Intersections dhe87 = new Intersections(87,42.67171209,-83.21615562);
        dhe87.setName("room 157");//also room 157A
        Intersections dhe88 = new Intersections(88,42.67185703,-83.21650296);
        dhe88.setName("courtyard");//??
        Intersections dhe89 = new Intersections(89,42.67188366,-83.21650162);
        dhe89.setName("entrance room 200 (first floor)");
        Intersections dhe90 = new Intersections(90,42.67185605,-83.21653381);
        dhe90.setName("entrance room 201 (first floor)");
        Intersections dhe91 = new Intersections(91,42.67185506,-83.21675643);
        dhe91.setName("entrance room 201 (first floor)");
        Intersections dhe92 = new Intersections(92,42.67187971,-83.21675643);
        dhe92.setName("entrance room 203 (first floor)");
        //extra points added
        Intersections dhe93 = new Intersections(93,42.67167363,-83.21615562);
        dhe93.setName("room 158 side");
        Intersections dhe94 = new Intersections(94,42.67159277,-83.21650028);
        dhe94.setName("hallway in front of 143");
        Intersections dhe95 = new Intersections(95,42.67138373,-83.21661025);
        dhe95.setName("room 136 stair side");
        Intersections dhe96 = new Intersections(96,42.67138324,-83.21657337);
        dhe96.setName("stair-room 137");
        Intersections dhe97 = new Intersections(97,42.67166130,-83.21679264);
        dhe97.setName("next to men's bathroom");
        Intersections dhe98 = new Intersections(98,42.67168546,-83.21676582);
        dhe98.setName("intersect with stairs, bathroom");

        // arrays used to store the distance calculation between two connected nodes (simulating weighted edges)
		float[] dist2points1 = new float[3];
		float[] dist2points2 = new float[3];
		float[] dist2points3 = new float[3];
		float[] dist2points4 = new float[3];
		float[] dist2points5 = new float[3];
		float[] dist2points6 = new float[3];
		float[] dist2points7 = new float[3];
		float[] dist2points8 = new float[3];
		float[] dist2points9 = new float[3];
		float[] dist2points10 = new float[3];
		float[] dist2points11 = new float[3];
		float[] dist2points12 = new float[3];
		float[] dist2points13 = new float[3];
		float[] dist2points14 = new float[3];
		float[] dist2points15 = new float[3];
		float[] dist2points16 = new float[3];
		float[] dist2points17 = new float[3];
		float[] dist2points18 = new float[3];
		float[] dist2points19 = new float[3];
		float[] dist2points20 = new float[3];
		float[] dist2points21 = new float[3];
		float[] dist2points22 = new float[3];
		float[] dist2points23 = new float[3];
		float[] dist2points24 = new float[3];
		float[] dist2points25 = new float[3];
		float[] dist2points26 = new float[3];
		float[] dist2points27 = new float[3];
		float[] dist2points28 = new float[3];
		float[] dist2points29 = new float[3];
		float[] dist2points30 = new float[3];
		float[] dist2points31 = new float[3];
		float[] dist2points32 = new float[3];
		float[] dist2points33 = new float[3];
		float[] dist2points34 = new float[3];
		float[] dist2points35 = new float[3];
		float[] dist2points36 = new float[3];
		float[] dist2points37 = new float[3];
		float[] dist2points38 = new float[3];
		float[] dist2points39 = new float[3];
		float[] dist2points40 = new float[3];
		float[] dist2points41 = new float[3];
		float[] dist2points42 = new float[3];
		float[] dist2points43 = new float[3];
		float[] dist2points44 = new float[3];
		float[] dist2points45 = new float[3];
		float[] dist2points46 = new float[3];
		float[] dist2points47 = new float[3];
		float[] dist2points48 = new float[3];
		float[] dist2points49 = new float[3];
		float[] dist2points50 = new float[3];
		float[] dist2points51 = new float[3];
		float[] dist2points52 = new float[3];
		float[] dist2points53 = new float[3];
		float[] dist2points54 = new float[3];
		float[] dist2points55 = new float[3];
		float[] dist2points56 = new float[3];
		float[] dist2points57 = new float[3];
		float[] dist2points58 = new float[3];
		float[] dist2points59 = new float[3];
		float[] dist2points60 = new float[3];
		float[] dist2points61 = new float[3];
		float[] dist2points62 = new float[3];
		float[] dist2points63 = new float[3];
		float[] dist2points64 = new float[3];
		float[] dist2points65 = new float[3];
		float[] dist2points66 = new float[3];
		float[] dist2points67 = new float[3];
		float[] dist2points68 = new float[3];
		float[] dist2points69 = new float[3];
		float[] dist2points70 = new float[3];
		float[] dist2points71 = new float[3];
		float[] dist2points72 = new float[3];
		float[] dist2points73 = new float[3];
		float[] dist2points74 = new float[3];
		float[] dist2points75 = new float[3];
		float[] dist2points76 = new float[3];
		float[] dist2points77 = new float[3];
		float[] dist2points78 = new float[3];
		float[] dist2points79 = new float[3];
		float[] dist2points80 = new float[3];
		float[] dist2points81 = new float[3];
		float[] dist2points82 = new float[3];
		float[] dist2points83 = new float[3];
		float[] dist2points84 = new float[3];
		float[] dist2points85 = new float[3];
		float[] dist2points86 = new float[3];
		float[] dist2points87 = new float[3];
		float[] dist2points88 = new float[3];
		float[] dist2points89 = new float[3];
		float[] dist2points90 = new float[3];
		float[] dist2points91 = new float[3];
		float[] dist2points92 = new float[3];
		float[] dist2points93 = new float[3];
		float[] dist2points94 = new float[3];
		float[] dist2points95 = new float[3];
        //new added
        float[] dist2points96 = new float[3];
        float[] dist2points97 = new float[3];
        float[] dist2points98 = new float[3];
        float[] dist2points99 = new float[3];
        float[] dist2points100 = new float[3];
        float[] dist2points101 = new float[3];

        // distanceBetween() method takes two nodes' latitude and longitude and computes the distance between them as a straight line
		distanceBetween(dhe1.getLat(),dhe1.getLon(),dhe2.getLat(),dhe2.getLon(),dist2points1);
		distanceBetween(dhe2.getLat(),dhe2.getLon(),dhe3.getLat(),dhe3.getLon(),dist2points2);
		distanceBetween(dhe3.getLat(),dhe3.getLon(),dhe4.getLat(),dhe4.getLon(),dist2points3);
		distanceBetween(dhe3.getLat(),dhe3.getLon(),dhe4.getLat(),dhe4.getLon(),dist2points4);
        distanceBetween(dhe3.getLat(),dhe3.getLon(),dhe93.getLat(),dhe93.getLon(),dist2points5);
        distanceBetween(dhe93.getLat(),dhe93.getLon(),dhe87.getLat(),dhe87.getLon(),dist2points96);//
        distanceBetween(dhe4.getLat(),dhe4.getLon(),dhe5.getLat(),dhe5.getLon(),dist2points6);
		distanceBetween(dhe5.getLat(),dhe5.getLon(),dhe6.getLat(),dhe6.getLon(),dist2points7);
		distanceBetween(dhe6.getLat(),dhe6.getLon(),dhe7.getLat(),dhe7.getLon(),dist2points8);
		distanceBetween(dhe7.getLat(),dhe7.getLon(),dhe8.getLat(),dhe8.getLon(),dist2points9);
		distanceBetween(dhe8.getLat(),dhe8.getLon(),dhe9.getLat(),dhe9.getLon(),dist2points10);
		distanceBetween(dhe9.getLat(),dhe9.getLon(),dhe10.getLat(),dhe10.getLon(),dist2points11);
		distanceBetween(dhe10.getLat(),dhe10.getLon(),dhe11.getLat(),dhe11.getLon(),dist2points12);
		distanceBetween(dhe11.getLat(),dhe11.getLon(),dhe12.getLat(),dhe12.getLon(),dist2points13);
		distanceBetween(dhe12.getLat(),dhe12.getLon(),dhe13.getLat(),dhe13.getLon(),dist2points14);
		distanceBetween(dhe13.getLat(),dhe13.getLon(),dhe14.getLat(),dhe14.getLon(),dist2points15);
		distanceBetween(dhe14.getLat(),dhe14.getLon(),dhe15.getLat(),dhe15.getLon(),dist2points16);
		distanceBetween(dhe15.getLat(),dhe15.getLon(),dhe16.getLat(),dhe16.getLon(),dist2points17);
        distanceBetween(dhe94.getLat(),dhe94.getLon(),dhe15.getLat(),dhe15.getLon(),dist2points18);
        distanceBetween(dhe94.getLat(),dhe94.getLon(),dhe76.getLat(),dhe76.getLon(),dist2points97);//
        distanceBetween(dhe16.getLat(),dhe16.getLon(),dhe17.getLat(),dhe17.getLon(),dist2points19);
		distanceBetween(dhe17.getLat(),dhe17.getLon(),dhe18.getLat(),dhe18.getLon(),dist2points20);
		distanceBetween(dhe18.getLat(),dhe18.getLon(),dhe19.getLat(),dhe19.getLon(),dist2points21);
		distanceBetween(dhe19.getLat(),dhe19.getLon(),dhe20.getLat(),dhe20.getLon(),dist2points22);
		distanceBetween(dhe20.getLat(),dhe20.getLon(),dhe21.getLat(),dhe21.getLon(),dist2points23);
		distanceBetween(dhe21.getLat(),dhe21.getLon(),dhe22.getLat(),dhe22.getLon(),dist2points24);
		distanceBetween(dhe22.getLat(),dhe22.getLon(),dhe23.getLat(),dhe23.getLon(),dist2points25);
        distanceBetween(dhe96.getLat(),dhe96.getLon(),dhe23.getLat(),dhe23.getLon(),dist2points26);
        distanceBetween(dhe96.getLat(),dhe96.getLon(),dhe95.getLat(),dhe95.getLon(),dist2points98);//
        distanceBetween(dhe95.getLat(),dhe95.getLon(),dhe24.getLat(),dhe24.getLon(),dist2points99);//
        distanceBetween(dhe24.getLat(),dhe24.getLon(),dhe25.getLat(),dhe25.getLon(),dist2points27);
		distanceBetween(dhe24.getLat(),dhe24.getLon(),dhe26.getLat(),dhe26.getLon(),dist2points28);
		distanceBetween(dhe26.getLat(),dhe26.getLon(),dhe27.getLat(),dhe27.getLon(),dist2points29);
		distanceBetween(dhe27.getLat(),dhe27.getLon(),dhe28.getLat(),dhe28.getLon(),dist2points30);
		distanceBetween(dhe28.getLat(),dhe28.getLon(),dhe29.getLat(),dhe29.getLon(),dist2points31);
		distanceBetween(dhe29.getLat(),dhe29.getLon(),dhe30.getLat(),dhe30.getLon(),dist2points32);
		distanceBetween(dhe30.getLat(),dhe30.getLon(),dhe31.getLat(),dhe31.getLon(),dist2points33);
		distanceBetween(dhe31.getLat(),dhe31.getLon(),dhe32.getLat(),dhe32.getLon(),dist2points34);
		distanceBetween(dhe32.getLat(),dhe32.getLon(),dhe33.getLat(),dhe33.getLon(),dist2points35);
		distanceBetween(dhe33.getLat(),dhe33.getLon(),dhe34.getLat(),dhe34.getLon(),dist2points36);
		distanceBetween(dhe34.getLat(),dhe34.getLon(),dhe35.getLat(),dhe35.getLon(),dist2points37);
		distanceBetween(dhe35.getLat(),dhe35.getLon(),dhe36.getLat(),dhe36.getLon(),dist2points38);
		distanceBetween(dhe36.getLat(),dhe36.getLon(),dhe37.getLat(),dhe37.getLon(),dist2points39);
		distanceBetween(dhe37.getLat(),dhe37.getLon(),dhe38.getLat(),dhe38.getLon(),dist2points40);
		distanceBetween(dhe37.getLat(),dhe37.getLon(),dhe69.getLat(),dhe69.getLon(),dist2points41);
		distanceBetween(dhe38.getLat(),dhe38.getLon(),dhe39.getLat(),dhe39.getLon(),dist2points42);
		distanceBetween(dhe39.getLat(),dhe39.getLon(),dhe40.getLat(),dhe40.getLon(),dist2points43);
		distanceBetween(dhe40.getLat(),dhe40.getLon(),dhe41.getLat(),dhe41.getLon(),dist2points44);
		distanceBetween(dhe41.getLat(),dhe41.getLon(),dhe42.getLat(),dhe42.getLon(),dist2points45);
		distanceBetween(dhe42.getLat(),dhe42.getLon(),dhe43.getLat(),dhe43.getLon(),dist2points46);
		distanceBetween(dhe43.getLat(),dhe43.getLon(),dhe44.getLat(),dhe44.getLon(),dist2points47);
		distanceBetween(dhe44.getLat(),dhe44.getLon(),dhe45.getLat(),dhe45.getLon(),dist2points48);
		distanceBetween(dhe45.getLat(),dhe45.getLon(),dhe46.getLat(),dhe46.getLon(),dist2points49);
		distanceBetween(dhe46.getLat(),dhe46.getLon(),dhe47.getLat(),dhe47.getLon(),dist2points50);
		distanceBetween(dhe47.getLat(),dhe47.getLon(),dhe48.getLat(),dhe48.getLon(),dist2points51);
		distanceBetween(dhe48.getLat(),dhe48.getLon(),dhe49.getLat(),dhe49.getLon(),dist2points52);
		distanceBetween(dhe49.getLat(),dhe49.getLon(),dhe50.getLat(),dhe50.getLon(),dist2points53);
		distanceBetween(dhe50.getLat(),dhe50.getLon(),dhe51.getLat(),dhe51.getLon(),dist2points54);
		distanceBetween(dhe51.getLat(),dhe51.getLon(),dhe52.getLat(),dhe52.getLon(),dist2points55);
		distanceBetween(dhe52.getLat(),dhe52.getLon(),dhe53.getLat(),dhe53.getLon(),dist2points56);
		distanceBetween(dhe52.getLat(),dhe52.getLon(),dhe54.getLat(),dhe54.getLon(),dist2points57);
		distanceBetween(dhe54.getLat(),dhe54.getLon(),dhe55.getLat(),dhe55.getLon(),dist2points58);
		distanceBetween(dhe55.getLat(),dhe55.getLon(),dhe56.getLat(),dhe56.getLon(),dist2points59);
		distanceBetween(dhe56.getLat(),dhe56.getLon(),dhe57.getLat(),dhe57.getLon(),dist2points60);
		distanceBetween(dhe57.getLat(),dhe57.getLon(),dhe58.getLat(),dhe58.getLon(),dist2points61);
		distanceBetween(dhe58.getLat(),dhe58.getLon(),dhe59.getLat(),dhe59.getLon(),dist2points62);
		distanceBetween(dhe59.getLat(),dhe59.getLon(),dhe60.getLat(),dhe60.getLon(),dist2points63);
		distanceBetween(dhe60.getLat(),dhe60.getLon(),dhe61.getLat(),dhe61.getLon(),dist2points64);
		distanceBetween(dhe61.getLat(),dhe61.getLon(),dhe62.getLat(),dhe62.getLon(),dist2points65);
		distanceBetween(dhe62.getLat(),dhe62.getLon(),dhe63.getLat(),dhe63.getLon(),dist2points66);
		distanceBetween(dhe63.getLat(),dhe63.getLon(),dhe64.getLat(),dhe64.getLon(),dist2points67);
		distanceBetween(dhe64.getLat(),dhe64.getLon(),dhe65.getLat(),dhe65.getLon(),dist2points68);
		distanceBetween(dhe65.getLat(),dhe65.getLon(),dhe66.getLat(),dhe66.getLon(),dist2points69);
		distanceBetween(dhe66.getLat(),dhe66.getLon(),dhe67.getLat(),dhe67.getLon(),dist2points70);
		distanceBetween(dhe66.getLat(),dhe66.getLon(),dhe70.getLat(),dhe70.getLon(),dist2points71);
        distanceBetween(dhe97.getLat(),dhe97.getLon(),dhe67.getLat(),dhe67.getLon(),dist2points72);
        distanceBetween(dhe97.getLat(),dhe97.getLon(),dhe68.getLat(),dhe68.getLon(),dist2points100);//
        distanceBetween(dhe98.getLat(),dhe98.getLon(),dhe67.getLat(),dhe67.getLon(),dist2points73);
        distanceBetween(dhe98.getLat(),dhe98.getLon(),dhe71.getLat(),dhe71.getLon(),dist2points101);//
        distanceBetween(dhe68.getLat(),dhe68.getLon(),dhe69.getLat(),dhe69.getLon(),dist2points74);
		distanceBetween(dhe71.getLat(),dhe71.getLon(),dhe72.getLat(),dhe72.getLon(),dist2points75);
		distanceBetween(dhe72.getLat(),dhe72.getLon(),dhe73.getLat(),dhe73.getLon(),dist2points76);
		distanceBetween(dhe73.getLat(),dhe73.getLon(),dhe74.getLat(),dhe74.getLon(),dist2points77);
		distanceBetween(dhe74.getLat(),dhe74.getLon(),dhe75.getLat(),dhe75.getLon(),dist2points78);
		distanceBetween(dhe75.getLat(),dhe75.getLon(),dhe76.getLat(),dhe76.getLon(),dist2points79);
		distanceBetween(dhe75.getLat(),dhe75.getLon(),dhe77.getLat(),dhe77.getLon(),dist2points80);
		distanceBetween(dhe77.getLat(),dhe77.getLon(),dhe78.getLat(),dhe78.getLon(),dist2points81);
		distanceBetween(dhe78.getLat(),dhe78.getLon(),dhe79.getLat(),dhe79.getLon(),dist2points82);
		distanceBetween(dhe79.getLat(),dhe79.getLon(),dhe80.getLat(),dhe80.getLon(),dist2points83);
		distanceBetween(dhe80.getLat(),dhe80.getLon(),dhe81.getLat(),dhe81.getLon(),dist2points84);
		distanceBetween(dhe81.getLat(),dhe81.getLon(),dhe82.getLat(),dhe82.getLon(),dist2points85);
		distanceBetween(dhe82.getLat(),dhe82.getLon(),dhe83.getLat(),dhe83.getLon(),dist2points86);
		distanceBetween(dhe83.getLat(),dhe83.getLon(),dhe84.getLat(),dhe84.getLon(),dist2points87);
		distanceBetween(dhe84.getLat(),dhe84.getLon(),dhe85.getLat(),dhe85.getLon(),dist2points88);
		distanceBetween(dhe85.getLat(),dhe85.getLon(),dhe86.getLat(),dhe86.getLon(),dist2points89);
		distanceBetween(dhe86.getLat(),dhe86.getLon(),dhe87.getLat(),dhe87.getLon(),dist2points90);
		distanceBetween(dhe88.getLat(),dhe88.getLon(),dhe77.getLat(),dhe77.getLon(),dist2points91);
		distanceBetween(dhe88.getLat(),dhe88.getLon(),dhe89.getLat(),dhe89.getLon(),dist2points92);
		distanceBetween(dhe90.getLat(),dhe90.getLon(),dhe88.getLat(),dhe88.getLon(),dist2points93);
		distanceBetween(dhe91.getLat(),dhe91.getLon(),dhe66.getLat(),dhe66.getLon(),dist2points94);
		distanceBetween(dhe91.getLat(),dhe91.getLon(),dhe92.getLat(),dhe92.getLon(),dist2points95);

        // Paths objects have each edge information (to, from, distanceBetween)
		Paths dp1 = new Paths(2,1,dist2points1[0]);
        Paths dp2 = new Paths(1,2,dist2points1[0]);
		Paths dp3 = new Paths(3,2,dist2points2[0]);//need to add extra path for f2 if connecting to 2nd floor
		Paths dp4 = new Paths(2,3,dist2points2[0]);
		Paths dp5 = new Paths(4,3,dist2points4[0]);
		Paths dp6 = new Paths(93,3,dist2points5[0]);
        Paths dp189 = new Paths(3,93,dist2points5[0]);//
		Paths dp7 = new Paths(3,4,dist2points4[0]);
        Paths dp8 = new Paths(5,4,dist2points6[0]);
		Paths dp9 = new Paths(4,5,dist2points6[0]);
		Paths dp10 = new Paths(6,5,dist2points7[0]);
		Paths dp11 = new Paths(5,6,dist2points7[0]);
		Paths dp12 = new Paths(7,6,dist2points8[0]);
		Paths dp13 = new Paths(6,7,dist2points8[0]);
		Paths dp14 = new Paths(8,7,dist2points9[0]);
		Paths dp15 = new Paths(7,8,dist2points9[0]);
		Paths dp16 = new Paths(9,8,dist2points10[0]);
		Paths dp17 = new Paths(8,9,dist2points10[0]);
        Paths dp18 = new Paths(10,9,dist2points11[0]);
		Paths dp19 = new Paths(9,10,dist2points11[0]);
		Paths dp20 = new Paths(11,10,dist2points12[0]);
		Paths dp21 = new Paths(10,11,dist2points12[0]);
		Paths dp22 = new Paths(12,11,dist2points13[0]);
		Paths dp23 = new Paths(11,12,dist2points13[0]);
		Paths dp24 = new Paths(13,12,dist2points14[0]);
		Paths dp25 = new Paths(12,13,dist2points14[0]);
		Paths dp26 = new Paths(14,13,dist2points15[0]);
        Paths dp27 = new Paths(13,14,dist2points15[0]);
		Paths dp28 = new Paths(15,14,dist2points16[0]);
		Paths dp29 = new Paths(14,15,dist2points16[0]);
		Paths dp30 = new Paths(16,15,dist2points17[0]);
        Paths dp31 = new Paths(94,15,dist2points18[0]);
        Paths dp190 = new Paths(15,94,dist2points18[0]);//
		Paths dp32 = new Paths(15,16,dist2points17[0]);
		Paths dp33 = new Paths(17,16,dist2points19[0]);
		Paths dp34 = new Paths(16,17,dist2points19[0]);
		Paths dp35 = new Paths(18,17,dist2points20[0]);
		Paths dp36 = new Paths(17,18,dist2points20[0]);
        Paths dp37 = new Paths(19,18,dist2points21[0]);
		Paths dp38 = new Paths(18,19,dist2points21[0]);
		Paths dp39 = new Paths(20,19,dist2points22[0]);
		Paths dp40 = new Paths(19,20,dist2points22[0]);
		Paths dp41 = new Paths(21,20,dist2points23[0]);
		Paths dp42 = new Paths(20,21,dist2points23[0]);
		Paths dp43 = new Paths(22,21,dist2points24[0]);
		Paths dp44 = new Paths(21,22,dist2points24[0]);
		Paths dp45 = new Paths(23,22,dist2points25[0]);
		Paths dp46 = new Paths(22,23,dist2points25[0]);
        Paths dp47 = new Paths(96,23,dist2points26[0]);
        Paths dp191 = new Paths(23,96,dist2points26[0]);//
        Paths dp192 = new Paths(95,96,dist2points98[0]);//
        Paths dp193 = new Paths(96,95,dist2points98[0]);//
        Paths dp48 = new Paths(95,24,dist2points99[0]);
        Paths dp194 = new Paths(24,95,dist2points99[0]);//
        Paths dp49 = new Paths(25,24,dist2points27[0]);
		Paths dp50 = new Paths(26,24,dist2points28[0]);
		Paths dp51 = new Paths(24,25,dist2points27[0]);//need to add extra path for f2 if connecting to 2nd floor
		Paths dp52 = new Paths(24,26,dist2points28[0]);
		Paths dp53 = new Paths(27,26,dist2points29[0]);
		Paths dp54 = new Paths(26,27,dist2points29[0]);
		Paths dp55 = new Paths(28,27,dist2points30[0]);
		Paths dp56 = new Paths(27,28,dist2points30[0]);
        Paths dp57 = new Paths(29,28,dist2points31[0]);
		Paths dp58 = new Paths(28,29,dist2points31[0]);
		Paths dp59 = new Paths(30,29,dist2points32[0]);
		Paths dp60 = new Paths(29,30,dist2points32[0]);
		Paths dp61 = new Paths(31,30,dist2points33[0]);
		Paths dp62 = new Paths(30,31,dist2points33[0]);
		Paths dp63 = new Paths(32,31,dist2points34[0]);
		Paths dp64 = new Paths(31,32,dist2points34[0]);
		Paths dp65 = new Paths(33,32,dist2points35[0]);
		Paths dp66 = new Paths(32,33,dist2points35[0]);
        Paths dp67 = new Paths(34,33,dist2points36[0]);
		Paths dp68 = new Paths(33,34,dist2points36[0]);
		Paths dp69 = new Paths(35,34,dist2points37[0]);//need to add extra path for f2 if connecting
		Paths dp70 = new Paths(34,35,dist2points37[0]);
		Paths dp71 = new Paths(36,35,dist2points38[0]);
		Paths dp72 = new Paths(35,36,dist2points38[0]);
		Paths dp73 = new Paths(37,36,dist2points39[0]);
		Paths dp74 = new Paths(36,37,dist2points39[0]);
		Paths dp75 = new Paths(38,37,dist2points40[0]);
		Paths dp76 = new Paths(69,37,dist2points41[0]);
		Paths dp77 = new Paths(37,38,dist2points40[0]);
        Paths dp78 = new Paths(39,38,dist2points42[0]);
		Paths dp79 = new Paths(38,39,dist2points42[0]);
		Paths dp80 = new Paths(40,39,dist2points43[0]);
		Paths dp81 = new Paths(39,40,dist2points43[0]);
		Paths dp82 = new Paths(41,40,dist2points44[0]);
		Paths dp83 = new Paths(40,41,dist2points44[0]);
		Paths dp84 = new Paths(42,41,dist2points45[0]);
		Paths dp85 = new Paths(41,42,dist2points45[0]);
		Paths dp86 = new Paths(43,42,dist2points46[0]);
		Paths dp87 = new Paths(42,43,dist2points46[0]);
        Paths dp88 = new Paths(44,43,dist2points47[0]);
		Paths dp89 = new Paths(43,44,dist2points47[0]);
		Paths dp90 = new Paths(45,44,dist2points48[0]);
		Paths dp91 = new Paths(44,45,dist2points48[0]);
		Paths dp92 = new Paths(46,45,dist2points49[0]);
		Paths dp93 = new Paths(45,46,dist2points49[0]);
		Paths dp94 = new Paths(47,46,dist2points50[0]);
		Paths dp95 = new Paths(46,47,dist2points50[0]);
		Paths dp96 = new Paths(48,47,dist2points51[0]);
		Paths dp97 = new Paths(47,48,dist2points51[0]);
		Paths dp98 = new Paths(49,48,dist2points52[0]);
        Paths dp99 = new Paths(48,49,dist2points52[0]);
		Paths dp100 = new Paths(50,49,dist2points53[0]);
		Paths dp101 = new Paths(49,50,dist2points53[0]);
		Paths dp102 = new Paths(51,50,dist2points54[0]);
		Paths dp103 = new Paths(50,51,dist2points54[0]);
		Paths dp104 = new Paths(52,51,dist2points55[0]);
		Paths dp105 = new Paths(51,52,dist2points55[0]);
		Paths dp106 = new Paths(53,52,dist2points56[0]);
		Paths dp107 = new Paths(54,52,dist2points57[0]);
		Paths dp108 = new Paths(52,53,dist2points56[0]);//add extra path for connection to hannah if connecting
        Paths dp109 = new Paths(52,54,dist2points57[0]);
		Paths dp110 = new Paths(55,54,dist2points58[0]);
		Paths dp111 = new Paths(54,55,dist2points58[0]);
		Paths dp112 = new Paths(56,55,dist2points59[0]);
		Paths dp113 = new Paths(55,56,dist2points59[0]);
		Paths dp114 = new Paths(57,56,dist2points60[0]);
		Paths dp115 = new Paths(56,57,dist2points60[0]);
		Paths dp116 = new Paths(58,57,dist2points61[0]);
		Paths dp117 = new Paths(57,58,dist2points61[0]);
		Paths dp118 = new Paths(59,58,dist2points62[0]);
        Paths dp119 = new Paths(58,59,dist2points62[0]);
		Paths dp120 = new Paths(60,59,dist2points63[0]);
		Paths dp121 = new Paths(59,60,dist2points63[0]);
		Paths dp122 = new Paths(61,60,dist2points64[0]);
		Paths dp123 = new Paths(60,61,dist2points64[0]);
		Paths dp124 = new Paths(62,61,dist2points65[0]);
		Paths dp125 = new Paths(61,62,dist2points65[0]);
		Paths dp126 = new Paths(63,62,dist2points66[0]);
		Paths dp127 = new Paths(62,63,dist2points66[0]);
		Paths dp128 = new Paths(64,63,dist2points67[0]);
        Paths dp129 = new Paths(63,64,dist2points67[0]);
		Paths dp130 = new Paths(65,64,dist2points68[0]);
		Paths dp131 = new Paths(64,65,dist2points68[0]);
		Paths dp132 = new Paths(66,65,dist2points69[0]);
		Paths dp133 = new Paths(65,66,dist2points69[0]);
		Paths dp134 = new Paths(67,66,dist2points70[0]);
		Paths dp135 = new Paths(70,66,dist2points71[0]);
		Paths dp136 = new Paths(91,66,dist2points94[0]);
		Paths dp137 = new Paths(66,67,dist2points70[0]);
		Paths dp138 = new Paths(97,67,dist2points72[0]);
        Paths dp195 = new Paths(67,97,dist2points72[0]);//
        Paths dp139 = new Paths(98,67,dist2points73[0]);
        Paths dp196 = new Paths(67,98,dist2points73[0]);//
        Paths dp140 = new Paths(97,68,dist2points100[0]);
        Paths dp197 = new Paths(68,97,dist2points100[0]);//
        Paths dp141 = new Paths(69,68,dist2points74[0]);
		Paths dp142= new Paths(37,69,dist2points41[0]);
		Paths dp143 = new Paths(68,69,dist2points74[0]);
		Paths dp144 = new Paths(66,70,dist2points71[0]);//need extra path for f2 and f1 if connecting
		Paths dp145 = new Paths(98,71,dist2points101[0]);
        Paths dp198 = new Paths(71,98,dist2points101[0]);//
        Paths dp146 = new Paths(72,71,dist2points75[0]);
		Paths dp147 = new Paths(71,72,dist2points75[0]);
		Paths dp148 = new Paths(73,72,dist2points76[0]);
        Paths dp149 = new Paths(72,73,dist2points76[0]);
		Paths dp150 = new Paths(74,73,dist2points77[0]);
		Paths dp151 = new Paths(73,74,dist2points77[0]);
		Paths dp152 = new Paths(75,74,dist2points78[0]);
		Paths dp153 = new Paths(74,75,dist2points78[0]);
		Paths dp154 = new Paths(76,75,dist2points79[0]);
		Paths dp155 = new Paths(77,75,dist2points80[0]);
		Paths dp156 = new Paths(94,76,dist2points97[0]);
        Paths dp199 = new Paths(76,94,dist2points97[0]);//
        Paths dp157 = new Paths(75,76,dist2points79[0]);
		Paths dp158 = new Paths(75,77,dist2points80[0]);
        Paths dp159 = new Paths(78,77,dist2points81[0]);
		Paths dp160 = new Paths(88,77,dist2points91[0]);
		Paths dp161 = new Paths(77,78,dist2points81[0]);
		Paths dp162 = new Paths(79,78,dist2points82[0]);
		Paths dp163 = new Paths(78,79,dist2points82[0]);
		Paths dp164 = new Paths(80,79,dist2points83[0]);
		Paths dp165 = new Paths(79,80,dist2points83[0]);
		Paths dp166 = new Paths(81,80,dist2points84[0]);
		Paths dp167 = new Paths(80,81,dist2points84[0]);
		Paths dp168 = new Paths(82,81,dist2points85[0]);
		Paths dp169 = new Paths(81,82,dist2points85[0]);
        Paths dp170 = new Paths(83,82,dist2points86[0]);
		Paths dp171 = new Paths(82,83,dist2points86[0]);
		Paths dp172 = new Paths(84,83,dist2points87[0]);
		Paths dp173 = new Paths(83,84,dist2points87[0]);
		Paths dp174 = new Paths(85,84,dist2points88[0]);
		Paths dp175 = new Paths(84,85,dist2points88[0]);
		Paths dp176 = new Paths(86,85,dist2points89[0]);
		Paths dp177 = new Paths(85,86,dist2points89[0]);
		Paths dp178 = new Paths(87,86,dist2points90[0]);
        Paths dp179 = new Paths(93,87,dist2points96[0]);
        Paths dp200 = new Paths(87,93,dist2points96[0]);//
        Paths dp180 = new Paths(86,87,dist2points90[0]);
		Paths dp181 = new Paths(77,88,dist2points91[0]);//disconnected, leds to first floor entrance to rooms that belong to the second floor
		Paths dp182 = new Paths(89,88,dist2points92[0]);//disconnected, "
		Paths dp183 = new Paths(90,88,dist2points93[0]);//disconnected, "
		Paths dp184 = new Paths(88,89,dist2points92[0]);
		Paths dp185 = new Paths(88,90,dist2points93[0]);
		Paths dp186 = new Paths(66,91,dist2points94[0]);//disconnected, "
		Paths dp187 = new Paths(92,91,dist2points95[0]);//disconnected, "
		Paths dp188 = new Paths(91,92,dist2points95[0]);

        // IntersectionNode creates an object from the original navigation nodes to be added to the graph and be linked
        IntersectionNode node1=new IntersectionNode(dhe1);
        IntersectionNode node2=new IntersectionNode(dhe2);
        IntersectionNode node3=new IntersectionNode(dhe3);
        IntersectionNode node4=new IntersectionNode(dhe4);
        IntersectionNode node5=new IntersectionNode(dhe5);
        IntersectionNode node6=new IntersectionNode(dhe6);
        IntersectionNode node7=new IntersectionNode(dhe7);
        IntersectionNode node8=new IntersectionNode(dhe8);
		IntersectionNode node9=new IntersectionNode(dhe9);
        IntersectionNode node10=new IntersectionNode(dhe10);
		IntersectionNode node11=new IntersectionNode(dhe11);
        IntersectionNode node12=new IntersectionNode(dhe12);
        IntersectionNode node13=new IntersectionNode(dhe13);
        IntersectionNode node14=new IntersectionNode(dhe14);
        IntersectionNode node15=new IntersectionNode(dhe15);
        IntersectionNode node16=new IntersectionNode(dhe16);
        IntersectionNode node17=new IntersectionNode(dhe17);
        IntersectionNode node18=new IntersectionNode(dhe18);
		IntersectionNode node19=new IntersectionNode(dhe19);
        IntersectionNode node20=new IntersectionNode(dhe20);
		IntersectionNode node21=new IntersectionNode(dhe21);
        IntersectionNode node22=new IntersectionNode(dhe22);
        IntersectionNode node23=new IntersectionNode(dhe23);
        IntersectionNode node24=new IntersectionNode(dhe24);
        IntersectionNode node25=new IntersectionNode(dhe25);
        IntersectionNode node26=new IntersectionNode(dhe26);
        IntersectionNode node27=new IntersectionNode(dhe27);
        IntersectionNode node28=new IntersectionNode(dhe28);
		IntersectionNode node29=new IntersectionNode(dhe29);
        IntersectionNode node30=new IntersectionNode(dhe30);
		IntersectionNode node31=new IntersectionNode(dhe31);
        IntersectionNode node32=new IntersectionNode(dhe32);
        IntersectionNode node33=new IntersectionNode(dhe33);
        IntersectionNode node34=new IntersectionNode(dhe34);
        IntersectionNode node35=new IntersectionNode(dhe35);
        IntersectionNode node36=new IntersectionNode(dhe36);
        IntersectionNode node37=new IntersectionNode(dhe37);
        IntersectionNode node38=new IntersectionNode(dhe38);
		IntersectionNode node39=new IntersectionNode(dhe39);
        IntersectionNode node40=new IntersectionNode(dhe40);
		IntersectionNode node41=new IntersectionNode(dhe41);
        IntersectionNode node42=new IntersectionNode(dhe42);
        IntersectionNode node43=new IntersectionNode(dhe43);
        IntersectionNode node44=new IntersectionNode(dhe44);
        IntersectionNode node45=new IntersectionNode(dhe45);
        IntersectionNode node46=new IntersectionNode(dhe46);
        IntersectionNode node47=new IntersectionNode(dhe47);
        IntersectionNode node48=new IntersectionNode(dhe48);
		IntersectionNode node49=new IntersectionNode(dhe49);
        IntersectionNode node50=new IntersectionNode(dhe50);
		IntersectionNode node51=new IntersectionNode(dhe51);
        IntersectionNode node52=new IntersectionNode(dhe52);
        IntersectionNode node53=new IntersectionNode(dhe53);
        IntersectionNode node54=new IntersectionNode(dhe54);
        IntersectionNode node55=new IntersectionNode(dhe55);
        IntersectionNode node56=new IntersectionNode(dhe56);
        IntersectionNode node57=new IntersectionNode(dhe57);
        IntersectionNode node58=new IntersectionNode(dhe58);
		IntersectionNode node59=new IntersectionNode(dhe59);
        IntersectionNode node60=new IntersectionNode(dhe60);
		IntersectionNode node61=new IntersectionNode(dhe61);
        IntersectionNode node62=new IntersectionNode(dhe62);
        IntersectionNode node63=new IntersectionNode(dhe63);
        IntersectionNode node64=new IntersectionNode(dhe64);
        IntersectionNode node65=new IntersectionNode(dhe65);
        IntersectionNode node66=new IntersectionNode(dhe66);
        IntersectionNode node67=new IntersectionNode(dhe67);
        IntersectionNode node68=new IntersectionNode(dhe68);
		IntersectionNode node69=new IntersectionNode(dhe69);
        IntersectionNode node70=new IntersectionNode(dhe70);
		IntersectionNode node71=new IntersectionNode(dhe71);
        IntersectionNode node72=new IntersectionNode(dhe72);
        IntersectionNode node73=new IntersectionNode(dhe73);
        IntersectionNode node74=new IntersectionNode(dhe74);
        IntersectionNode node75=new IntersectionNode(dhe75);
        IntersectionNode node76=new IntersectionNode(dhe76);
        IntersectionNode node77=new IntersectionNode(dhe77);
        IntersectionNode node78=new IntersectionNode(dhe78);
		IntersectionNode node79=new IntersectionNode(dhe79);
        IntersectionNode node80=new IntersectionNode(dhe80);
		IntersectionNode node81=new IntersectionNode(dhe81);
        IntersectionNode node82=new IntersectionNode(dhe82);
        IntersectionNode node83=new IntersectionNode(dhe83);
        IntersectionNode node84=new IntersectionNode(dhe84);
        IntersectionNode node85=new IntersectionNode(dhe85);
        IntersectionNode node86=new IntersectionNode(dhe86);
        IntersectionNode node87=new IntersectionNode(dhe87);
        IntersectionNode node88=new IntersectionNode(dhe88);
		IntersectionNode node89=new IntersectionNode(dhe89);
        IntersectionNode node90=new IntersectionNode(dhe90);
		IntersectionNode node91=new IntersectionNode(dhe91);
        IntersectionNode node92=new IntersectionNode(dhe92);
        //new added
        IntersectionNode node93=new IntersectionNode(dhe93);
        IntersectionNode node94=new IntersectionNode(dhe94);
        IntersectionNode node95=new IntersectionNode(dhe95);
        IntersectionNode node96=new IntersectionNode(dhe96);
        IntersectionNode node97=new IntersectionNode(dhe97);
        IntersectionNode node98=new IntersectionNode(dhe98);

        // creating an array of linked lists (hashed linked lists) so every array element (starting from 1) is a node in the graph
        // allows easy search of a node
		IntersectionNode[] ina_d = new IntersectionNode[99];
        ina_d[1]=node1;
        ina_d[2]=node2;
        ina_d[3]=node3;
        ina_d[4]=node4;
        ina_d[5]=node5;
        ina_d[6]=node6;
        ina_d[7]=node7;
        ina_d[8]=node8;
		ina_d[9]=node9;
        ina_d[10]=node10;
		ina_d[11]=node11;
        ina_d[12]=node12;
        ina_d[13]=node13;
        ina_d[14]=node14;
        ina_d[15]=node15;
        ina_d[16]=node16;
        ina_d[17]=node17;
        ina_d[18]=node18;
		ina_d[19]=node19;
        ina_d[20]=node20;
		ina_d[21]=node21;
        ina_d[22]=node22;
        ina_d[23]=node23;
        ina_d[24]=node24;
        ina_d[25]=node25;
        ina_d[26]=node26;
        ina_d[27]=node27;
        ina_d[28]=node28;
		ina_d[29]=node29;
        ina_d[30]=node30;
		ina_d[31]=node31;
        ina_d[32]=node32;
        ina_d[33]=node33;
        ina_d[34]=node34;
        ina_d[35]=node35;
        ina_d[36]=node36;
        ina_d[37]=node37;
        ina_d[38]=node38;
		ina_d[39]=node39;
        ina_d[40]=node40;
		ina_d[41]=node41;
        ina_d[42]=node42;
        ina_d[43]=node43;
        ina_d[44]=node44;
        ina_d[45]=node45;
        ina_d[46]=node46;
        ina_d[47]=node47;
        ina_d[48]=node48;
		ina_d[49]=node49;
        ina_d[50]=node50;
		ina_d[51]=node51;
        ina_d[52]=node52;
        ina_d[53]=node53;
        ina_d[54]=node54;
        ina_d[55]=node55;
        ina_d[56]=node56;
        ina_d[57]=node57;
        ina_d[58]=node58;
		ina_d[59]=node59;
        ina_d[60]=node60;
		ina_d[61]=node61;
        ina_d[62]=node62;
        ina_d[63]=node63;
        ina_d[64]=node64;
        ina_d[65]=node65;
        ina_d[66]=node66;
        ina_d[67]=node67;
        ina_d[68]=node68;
		ina_d[69]=node69;
        ina_d[70]=node70;
		ina_d[71]=node71;
        ina_d[72]=node72;
        ina_d[73]=node73;
        ina_d[74]=node74;
        ina_d[75]=node75;
        ina_d[76]=node76;
        ina_d[77]=node77;
        ina_d[78]=node78;
		ina_d[79]=node79;
        ina_d[80]=node80;
		ina_d[81]=node81;
        ina_d[82]=node82;
        ina_d[83]=node83;
        ina_d[84]=node84;
        ina_d[85]=node85;
        ina_d[86]=node86;
        ina_d[87]=node87;
        ina_d[88]=node88;
		ina_d[89]=node89;
        ina_d[90]=node90;
		ina_d[91]=node91;
        ina_d[92]=node92;
        //new added
        ina_d[93]=node93;
        ina_d[94]=node94;
        ina_d[95]=node95;
        ina_d[96]=node96;
        ina_d[97]=node97;
        ina_d[98]=node98;

        // inserts a node from the array element (and a path connecting it to something else) to the graph data structure
        // creates the graph
		graph.insertPath(node1, dp1);
        graph.insertPath(node2, dp2);
        graph.insertPath(node2, dp3);
		graph.insertPath(node3, dp4);
        graph.insertPath(node3, dp5);
        graph.insertPath(node3, dp6);
        graph.insertPath(node4, dp7);
        graph.insertPath(node4, dp8);
        graph.insertPath(node5, dp9);
        graph.insertPath(node5, dp10);
        graph.insertPath(node6, dp11);
        graph.insertPath(node6, dp12);
        graph.insertPath(node7, dp13);
        graph.insertPath(node7, dp14);
        graph.insertPath(node8, dp15);
        graph.insertPath(node8, dp16);
		graph.insertPath(node9, dp17);
        graph.insertPath(node9, dp18);
        graph.insertPath(node10, dp19);
        graph.insertPath(node10, dp20);
        graph.insertPath(node11, dp21);
        graph.insertPath(node11, dp22);
        graph.insertPath(node12, dp23);
        graph.insertPath(node12, dp24);
        graph.insertPath(node13, dp25);
        graph.insertPath(node13, dp26);
        graph.insertPath(node14, dp27);
        graph.insertPath(node14, dp28);
        graph.insertPath(node15, dp29);
        graph.insertPath(node15, dp30);
		graph.insertPath(node15, dp31);
        graph.insertPath(node16, dp32);
        graph.insertPath(node16, dp33);
        graph.insertPath(node17, dp34);
		graph.insertPath(node17, dp35);
        graph.insertPath(node18, dp36);
        graph.insertPath(node18, dp37);
        graph.insertPath(node19, dp38);
        graph.insertPath(node19, dp39);
        graph.insertPath(node20, dp40);
        graph.insertPath(node20, dp41);
        graph.insertPath(node21, dp42);
        graph.insertPath(node21, dp43);
        graph.insertPath(node22, dp44);
        graph.insertPath(node22, dp45);
        graph.insertPath(node23, dp46);
        graph.insertPath(node23, dp47);
        graph.insertPath(node24, dp48);
        graph.insertPath(node24, dp49);
        graph.insertPath(node25, dp50);
        graph.insertPath(node25, dp51);
        graph.insertPath(node26, dp52);
		graph.insertPath(node26, dp53);
        graph.insertPath(node27, dp54);
        graph.insertPath(node27, dp55);
        graph.insertPath(node28, dp56);
        graph.insertPath(node28, dp57);
        graph.insertPath(node29, dp58);
        graph.insertPath(node29, dp59);
        graph.insertPath(node30, dp60);
        graph.insertPath(node30, dp61);
        graph.insertPath(node31, dp62);
        graph.insertPath(node31, dp63);
        graph.insertPath(node32, dp64);
        graph.insertPath(node32, dp65);
        graph.insertPath(node33, dp66);
        graph.insertPath(node33, dp67);
        graph.insertPath(node34, dp68);
        graph.insertPath(node34, dp69);
        graph.insertPath(node35, dp70);
		graph.insertPath(node35, dp71);
        graph.insertPath(node36, dp72);
        graph.insertPath(node36, dp73);
        graph.insertPath(node37, dp74);
        graph.insertPath(node37, dp75);
        graph.insertPath(node37, dp76);
        graph.insertPath(node38, dp77);
        graph.insertPath(node38, dp78);
        graph.insertPath(node39, dp79);
        graph.insertPath(node39, dp80);
        graph.insertPath(node40, dp81);
        graph.insertPath(node40, dp82);
        graph.insertPath(node41, dp83);
        graph.insertPath(node41, dp84);
        graph.insertPath(node42, dp85);
        graph.insertPath(node42, dp86);
        graph.insertPath(node43, dp87);
        graph.insertPath(node43, dp88);
		graph.insertPath(node44, dp89);
        graph.insertPath(node44, dp90);
        graph.insertPath(node45, dp91);
        graph.insertPath(node45, dp92);
        graph.insertPath(node46, dp93);
        graph.insertPath(node46, dp94);
        graph.insertPath(node47, dp95);
        graph.insertPath(node47, dp96);
        graph.insertPath(node48, dp97);
        graph.insertPath(node48, dp98);
        graph.insertPath(node49, dp99);
        graph.insertPath(node49, dp100);
        graph.insertPath(node50, dp101);
        graph.insertPath(node50, dp102);
        graph.insertPath(node51, dp103);
        graph.insertPath(node51, dp104);
        graph.insertPath(node52, dp105);
        graph.insertPath(node52, dp106);
		graph.insertPath(node52, dp107);
        graph.insertPath(node53, dp108);
        graph.insertPath(node54, dp109);
        graph.insertPath(node54, dp110);
        graph.insertPath(node55, dp111);
        graph.insertPath(node55, dp112);
        graph.insertPath(node56, dp113);
        graph.insertPath(node56, dp114);
        graph.insertPath(node57, dp115);
        graph.insertPath(node57, dp116);
        graph.insertPath(node58, dp117);
        graph.insertPath(node58, dp118);
        graph.insertPath(node59, dp119);
        graph.insertPath(node59, dp120);
        graph.insertPath(node60, dp121);
        graph.insertPath(node60, dp122);
        graph.insertPath(node61, dp123);
        graph.insertPath(node61, dp124);
		graph.insertPath(node62, dp125);
        graph.insertPath(node62, dp126);
        graph.insertPath(node63, dp127);
        graph.insertPath(node63, dp128);
        graph.insertPath(node64, dp129);
        graph.insertPath(node64, dp130);
        graph.insertPath(node65, dp131);
        graph.insertPath(node65, dp132);
        graph.insertPath(node66, dp133);
        graph.insertPath(node66, dp134);
        graph.insertPath(node66, dp135);
        graph.insertPath(node66, dp136);
        graph.insertPath(node67, dp137);
        graph.insertPath(node67, dp138);
        graph.insertPath(node67, dp139);
        graph.insertPath(node68, dp140);
        graph.insertPath(node68, dp141);
        graph.insertPath(node69, dp142);
		graph.insertPath(node69, dp143);
        graph.insertPath(node70, dp144);
        graph.insertPath(node71, dp145);
        graph.insertPath(node71, dp146);
        graph.insertPath(node72, dp147);
        graph.insertPath(node72, dp148);
        graph.insertPath(node73, dp149);
        graph.insertPath(node73, dp150);
        graph.insertPath(node74, dp151);
        graph.insertPath(node74, dp152);
        graph.insertPath(node75, dp153);
        graph.insertPath(node75, dp154);
        graph.insertPath(node75, dp155);
        graph.insertPath(node76, dp156);
        graph.insertPath(node76, dp157);
        graph.insertPath(node77, dp158);
        graph.insertPath(node77, dp159);
        graph.insertPath(node77, dp160);
		graph.insertPath(node78, dp161);
        graph.insertPath(node78, dp162);
        graph.insertPath(node79, dp163);
        graph.insertPath(node79, dp164);
        graph.insertPath(node80, dp165);
        graph.insertPath(node80, dp166);
        graph.insertPath(node81, dp167);
        graph.insertPath(node81, dp168);
        graph.insertPath(node82, dp169);
        graph.insertPath(node82, dp170);
        graph.insertPath(node83, dp171);
        graph.insertPath(node83, dp172);
        graph.insertPath(node84, dp173);
        graph.insertPath(node84, dp174);
        graph.insertPath(node85, dp175);
        graph.insertPath(node85, dp176);
        graph.insertPath(node86, dp177);
        graph.insertPath(node86, dp178);
		graph.insertPath(node87, dp179);
        graph.insertPath(node87, dp180);
        //graph.insertPath(node88, dp181);//** nodes disconnected from the graph - first floor entrances to second floor rooms
        //graph.insertPath(node88, dp182);//** "
        //graph.insertPath(node88, dp183);//** "
        graph.insertPath(node89, dp184);
        graph.insertPath(node90, dp185);
        //graph.insertPath(node91, dp186);//** "
        //graph.insertPath(node91, dp187);//** "
        graph.insertPath(node92, dp188);
        //new added
        graph.insertPath(node93,dp189);
        graph.insertPath(node93,dp200);
        graph.insertPath(node94,dp190);
        graph.insertPath(node94,dp199);
        graph.insertPath(node95,dp193);
        graph.insertPath(node95,dp194);
        graph.insertPath(node96,dp191);
        graph.insertPath(node96,dp192);
        graph.insertPath(node97,dp195);
        graph.insertPath(node97,dp197);
        graph.insertPath(node98,dp196);
        graph.insertPath(node98,dp198);

        // uses data passed from IndoorNav activity, which was user input for the rooms they wish to navigate to
        // it converts the input string to a roomCode, which is the same as the array position of each respective node, so it knows where
        // to start the route calculation from the graph nodes/vertices.
        if(start.equals("101")){
            roomCode = 65;
        }
        else if(start.equals("102")){
            roomCode = 64;
        }
        else if(start.equals("103")){
            roomCode = 62;
        }
        else if(start.equals("103A")){
            roomCode = 63;
        }
        else if(start.equals("104")){
            roomCode = 61;
        }
        else if(start.equals("105")){
            roomCode = 60;
        }
        else if(start.equals("105A")){
            roomCode = 58;
        }
        else if(start.equals("106")){
            roomCode = 59;
        }
        else if(start.equals("107")){
            roomCode = 56;
        }
        else if(start.equals("108")){
            roomCode = 57;
        }
        else if(start.equals("109")){
            roomCode = 55;
        }
        else if(start.equals("110")){
            roomCode = 54;
        }
        else if(start.equals("111")){
            roomCode = 51;
        }
        else if(start.equals("112")){
            roomCode = 50;
        }
        else if(start.equals("113")){
            roomCode = 49;
        }
        else if(start.equals("114")){
            roomCode = 48;
        }
        else if(start.equals("115")){
            roomCode = 48;
        }
        else if(start.equals("116")){
            roomCode = 47;
        }
        else if(start.equals("117")){
            roomCode = 47;
        }
        else if(start.equals("118")){
            roomCode = 46;
        }
        else if(start.equals("119")){
            roomCode = 45;
        }
        else if(start.equals("120")){
            roomCode = 42;
        }
        else if(start.equals("120A")){
            roomCode = 44;
        }
        else if(start.equals("121")){
            roomCode = 43;
        }
        else if(start.equals("122")){
            roomCode = 41;
        }
        else if(start.equals("123")){
            roomCode = 39;
        }
        else if((start.equals("124"))){
            roomCode = 40;
        }
        else if(start.equals("125")){
            roomCode = 38;
        }
        else if(start.equals("126")){
            roomCode = 37;
        }
        else if(start.equals("127")){
            roomCode = 36;
        }
        else if(start.equals("173")){
            roomCode = 36;
        }
        else if(start.equals("128")){
            roomCode = 33;
        }
        else if(start.equals("129")){
            roomCode = 32;
        }
        else if(start.equals("130")){
            roomCode = 31;
        }
        else if(start.equals("131")){
            roomCode = 30;
        }
        else if(start.equals("132")){
            roomCode = 28;
        }
        else if(start.equals("133")){
            roomCode = 27;
        }
        else if(start.equals("134")){
            roomCode = 26;
        }
        else if(start.equals("135")){
            roomCode = 29;
        }
        else if(start.equals("136")){
            roomCode = 19;
        }
        else if(start.equals("136A")){
            roomCode = 19;
        }
        else if(start.equals("141")){
            roomCode = 19;
        }
        else if(start.equals("137")){
            roomCode = 23;
        }
        else if(start.equals("138")){
            roomCode = 22;
        }
        else if(start.equals("139")){
            roomCode = 21;
        }
        else if(start.equals("140")){
            roomCode = 20;
        }
        else if(start.equals("142")){
            roomCode = 18;
        }
        else if(start.equals("143")){
            roomCode = 15;
        }
        else if(start.equals("144")){
            roomCode = 17;
        }
        else if(start.equals("145")){
            roomCode = 76;
        }
        else if(start.equals("146")){
            roomCode = 14;
        }
        else if(start.equals("147")){
            roomCode = 13;
        }
        else if(start.equals("148")){
            roomCode = 12;
        }
        else if(start.equals("149")){
            roomCode = 10;
        }
        else if(start.equals("150")){
            roomCode = 11;
        }
        else if(start.equals("151")){
            roomCode = 8;
        }
        else if(start.equals("152")){
            roomCode = 7;
        }
        else if(start.equals("152A")){
            roomCode = 9;
        }
        else if(start.equals("153")){
            roomCode = 6;
        }
        else if(start.equals("154")){
            roomCode = 6;
        }
        else if(start.equals("155")){
            roomCode = 5;
        }
        else if(start.equals("155A")){
            roomCode = 5;
        }
        else if(start.equals("156")){
            roomCode = 4;
        }
        else if(start.equals("157")){
            roomCode = 87;
        }
        else if(start.equals("157A")){
            roomCode = 87;
        }
        else if(start.equals("158")){
            roomCode = 86;
        }
        else if(start.equals("159")){
            roomCode = 86;
        }
        else if(start.equals("159A")){
            roomCode = 85;
        }
        else if(start.equals("160")){
            roomCode = 84;
        }
        else if(start.equals("161")){
            roomCode = 83;
        }
        else if(start.equals("162")){
            roomCode = 82;
        }
        else if(start.equals("163")){
            roomCode = 81;
        }
        else if(start.equals("163A")){
            roomCode = 80;
        }
        else if(start.equals("164")){
            roomCode = 79;
        }
        else if(start.equals("165")){
            roomCode = 78;
        }
        else if(start.equals("166")){
            roomCode = 77;
        }
        else if(start.equals("167")){
            roomCode = 74;
        }
        else if(start.equals("168")){
            roomCode = 74;
        }
        else if(start.equals("169")){
            roomCode = 73;
        }
        else if(start.equals("170")){
            roomCode = 72;
        }
        else if(start.equals("171")){
            roomCode = 71;
        }

        // uses data passed from IndoorNav activity, which was user input for the rooms they wish to navigate to
        // it converts the input string to a roomCode, which is the same as the array position of each respective node, so it knows where
        // to stop the route calculation from the graph nodes/vertices.
        if(end.equals("101")){
            roomCode2 = 65;
        }
        else if(end.equals("102")){
            roomCode2 = 64;
        }
        else if(end.equals("103")){
            roomCode2 = 62;
        }
        else if(end.equals("103A")){
            roomCode2 = 63;
        }
        else if(end.equals("104")){
            roomCode2 = 61;
        }
        else if(end.equals("105")){
            roomCode2 = 60;
        }
        else if(end.equals("105A")){
            roomCode2 = 58;
        }
        else if(end.equals("106")){
            roomCode2 = 59;
        }
        else if(end.equals("107")){
            roomCode2 = 56;
        }
        else if(end.equals("108")){
            roomCode2 = 57;
        }
        else if(end.equals("109")){
            roomCode2 = 55;
        }
        else if(end.equals("110")){
            roomCode2 = 54;
        }
        else if(end.equals("111")){
            roomCode2 = 51;
        }
        else if(end.equals("112")){
            roomCode2 = 50;
        }
        else if(end.equals("113")){
            roomCode2 = 49;
        }
        else if(end.equals("114")){
            roomCode2 = 48;
        }
        else if(end.equals("115")){
            roomCode2 = 48;
        }
        else if(end.equals("116")){
            roomCode2 = 47;
        }
        else if(end.equals("117")){
            roomCode2 = 47;
        }
        else if(end.equals("118")){
            roomCode2 = 46;
        }
        else if(end.equals("119")){
            roomCode2 = 45;
        }
        else if(end.equals("120")){
            roomCode2 = 42;
        }
        else if(end.equals("120A")){
            roomCode2 = 44;
        }
        else if(end.equals("121")){
            roomCode2 = 43;
        }
        else if(end.equals("122")){
            roomCode2 = 41;
        }
        else if(end.equals("123")){
            roomCode2 = 39;
        }
        else if(end.equals("124")){
            roomCode2 = 40;
        }
        else if(end.equals("125")){
            roomCode2 = 38;
        }
        else if(end.equals("126")){
            roomCode2 = 37;
        }
        else if(end.equals("127")){
            roomCode2 = 36;
        }
        else if(end.equals("173")){
            roomCode2 = 36;
        }
        else if(end.equals("128")){
            roomCode2 = 33;
        }
        else if(end.equals("129")){
            roomCode2 = 32;
        }
        else if(end.equals("130")){
            roomCode2 = 31;
        }
        else if(end.equals("131")){
            roomCode2 = 30;
        }
        else if(end.equals("132")){
            roomCode2 = 28;
        }
        else if(end.equals("133")){
            roomCode2 = 27;
        }
        else if(end.equals("134")){
            roomCode2 = 26;
        }
        else if(end.equals("135")){
            roomCode2 = 29;
        }
        else if(end.equals("136")){
            roomCode2 = 19;
        }
        else if(end.equals("136A")){
            roomCode2 = 19;
        }
        else if(end.equals("141")){
            roomCode2 = 19;
        }
        else if(end.equals("137")){
            roomCode2 = 23;
        }
        else if(end.equals("138")){
            roomCode2 = 22;
        }
        else if(end.equals("139")){
            roomCode2 = 21;
        }
        else if(end.equals("140")){
            roomCode2 = 20;
        }
        else if(end.equals("142")){
            roomCode2 = 18;
        }
        else if(end.equals("143")){
            roomCode2 = 15;
        }
        else if(end.equals("144")){
            roomCode2 = 17;
        }
        else if(end.equals("145")){
            roomCode2 = 76;
        }
        else if(end.equals("146")){
            roomCode2 = 14;
        }
        else if(end.equals("147")){
            roomCode2 = 13;
        }
        else if(end.equals("148")){
            roomCode2 = 12;
        }
        else if(end.equals("149")){
            roomCode2 = 10;
        }
        else if(end.equals("150")){
            roomCode2 = 11;
        }
        else if(end.equals("151")){
            roomCode2 = 8;
        }
        else if(end.equals("152")){
            roomCode2 = 7;
        }
        else if(end.equals("152A")){
            roomCode2 = 9;
        }
        else if(end.equals("153")){
            roomCode2 = 6;
        }
        else if(end.equals("154")){
            roomCode2 = 6;
        }
        else if(end.equals("155")){
            roomCode2 = 5;
        }
        else if(end.equals("155A")){
            roomCode2 = 5;
        }
        else if(end.equals("156")){
            roomCode2 = 4;
        }
        else if(end.equals("157")){
            roomCode2 = 87;
        }
        else if(end.equals("157A")){
            roomCode2 = 87;
        }
        else if(end.equals("158")){
            roomCode2 = 86;
        }
        else if(end.equals("159")){
            roomCode2 = 86;
        }
        else if(end.equals("159A")){
            roomCode2 = 85;
        }
        else if(end.equals("160")){
            roomCode2 = 84;
        }
        else if(end.equals("161")){
            roomCode2 = 83;
        }
        else if(end.equals("162")){
            roomCode2 = 82;
        }
        else if(end.equals("163")){
            roomCode2 = 81;
        }
        else if(end.equals("163A")){
            roomCode2 = 80;
        }
        else if(end.equals("164")){
            roomCode2 = 79;
        }
        else if(end.equals("165")){
            roomCode2 = 78;
        }
        else if(end.equals("166")){
            roomCode2 = 77;
        }
        else if(end.equals("167")){
            roomCode2 = 74;
        }
        else if(end.equals("168")){
            roomCode2 = 74;
        }
        else if(end.equals("169")){
            roomCode2 = 73;
        }
        else if(end.equals("170")){
            roomCode2 = 72;
        }
        else if(end.equals("171")){
            roomCode2 = 71;
        }

        // call to method to calculate the navigation route, passing the user input for start and end locations
        Stack<IntersectionNode> inPath = DijkstraMod(ina_d,findStartIndoor(ina_d,roomCode),findEndIndoor(ina_d,roomCode2));
        //Stack<IntersectionNode> inPath = DijkstraMod(ina_d,node1,node42); // old static calls to specific rooms
        return(inPath); // stack returned after calculating the route, passed to IndoorNav class to display
    }

    // Outdoor graph initialization
    public static Stack<IntersectionNode> initializeOutdoor(String building){
        totalDist=0;

        // Nodes to form the graph data structure for outdoor navigation
        IntersectionList graph = new IntersectionList();
        Intersections n1 = new Intersections(1,42.67856275660974,-83.21195662021637);
        Intersections n2 = new Intersections(2,42.678128942599535,-83.21164011955261);
        Intersections n3 = new Intersections(3,42.677722732189736,-83.21133434772491);
        Intersections n4 = new Intersections(4,42.677091720461554,-83.21103930473328);
        Intersections n5 = new Intersections(5,42.676326610146305,-83.21084082126616);
        Intersections n6 = new Intersections(6,42.67642520736517,-83.21047067642212);
        Intersections n7 = new Intersections(7,42.676263507844126,-83.21108758449554);
        Intersections n8 = new Intersections(8,42.6759046122819,-83.21238040924072);
        Intersections n9 = new Intersections(9,42.675498387331615,-83.21319580078125);
        Intersections n10 = new Intersections(10,42.67509610369597,-83.2138180732727);
        Intersections n11 = new Intersections(11,42.67482791315882,-83.21418285369873);
        Intersections n12 = new Intersections(12,42.674587329486265,-83.21452617645264);
        Intersections n13 = new Intersections(13,42.6743112487144,-83.21469783782959);
        Intersections n14 = new Intersections(14,42.67395234187741,-83.21445643901825);
        Intersections n15 = new Intersections(15,42.67407066304172,-83.21378588676453);
        n15.setName("ATH Entrance");
        Intersections n16 = new Intersections(16,42.673246354248505,-83.21368396282196);
        Intersections n17 = new Intersections(17,42.673423837926634,-83.2134211063385);
        n17.setName("REC Entrance");
        Intersections n18 = new Intersections(18,42.67285983248454,-83.213329911232);
        Intersections n19 = new Intersections(19,42.67275334137208,-83.21251451969147);
        Intersections n20 = new Intersections(20,42.6725876881678,-83.21246087551117);
        Intersections n21 = new Intersections(21,42.67248119658905,-83.2112592458725);
        Intersections n22 = new Intersections(22,42.67228004533133,-83.21140944957733);
        Intersections n23 = new Intersections(23,42.672114390865545,-83.21103394031525);
        Intersections n24 = new Intersections(24,42.67151487577517,-83.21114659309387);
        Intersections n25 = new Intersections(25,42.67138471712968,-83.21086227893828);
        n25.setName("PH Entrance");
        Intersections n26 = new Intersections(26,42.67236287239864,-83.21089446544647);
        Intersections n27 = new Intersections(27,42.671771248067586,-83.2099449634552);
        Intersections n28 = new Intersections(28,42.67240625796127,-83.21346402168274);
        Intersections n29 = new Intersections(29,42.6718619641639,-83.21264326572418);
        n29.setName("VAR Entrance");
        Intersections n30 = new Intersections(30,42.67179885732831,-83.21298658847809);
        n30.setName("VAR Entrance");
        Intersections n31 = new Intersections(31,42.67185013163711,-83.21313142776489);
        n31.setName("VAR Entrance");
        Intersections n32 = new Intersections(32,42.672311598512835,-83.21315288543701);
        n32.setName("VAR Entrance");
        Intersections n33 = new Intersections(33,42.67239442553811,-83.21382343769072);
        n33.setName("EH Entrance");
        Intersections n34 = new Intersections(34,42.671869852513844,-83.21388781070709);
        n34.setName("EH Entrance");
        Intersections n35 = new Intersections(35,42.671447824385794,-83.2131689786911);
        Intersections n36 = new Intersections(36,42.67170025276941,-83.21315824985503);
        Intersections n37 = new Intersections(37,42.671696308583805,-83.21398437023161);
        Intersections n38 = new Intersections(38,42.67142415917226,-83.21365714073181);
        Intersections n39 = new Intersections(39,42.67145965698918,-83.21398437023161);
        Intersections n40 = new Intersections(40,42.6711717296673,-83.2139790058136);
        Intersections n41 = new Intersections(41,42.67243386693992,-83.21247160434723);
        Intersections n42 = new Intersections(42,42.671869852513844,-83.21251451969147);
        Intersections n43 = new Intersections(43,42.67280855900872,-83.21458518505096);
        Intersections n44 = new Intersections(44,42.67325818650948,-83.21520745754242);
        Intersections n45 = new Intersections(45,42.673250298335745,-83.21600139141083);
        Intersections n46 = new Intersections(46,42.673419893850394,-83.216033577919);
        Intersections n47 = new Intersections(47,42.673451446453235,-83.2161945104599);
        Intersections n48 = new Intersections(48,42.67376697160045,-83.21618914604187);
        Intersections n49 = new Intersections(49,42.67389712525699,-83.21599066257477);
        Intersections n50 = new Intersections(50,42.674204760088934,-83.21599066257477);
        Intersections n51 = new Intersections(51,42.67435463291693,-83.21573853492737);
        Intersections n52 = new Intersections(52,42.67451239339805,-83.21565806865692);
        n52.setName("ODH Entrance");
        Intersections n53 = new Intersections(53,42.674465065295756,-83.21551322937012);
        n53.setName("ODH Entrance");
        Intersections n54 = new Intersections(54,42.674015446526404,-83.2156902551651);
        Intersections n55 = new Intersections(55,42.67394050974862,-83.21530401706696);
        Intersections n56 = new Intersections(56,42.67402333460303,-83.21490168571472);
        Intersections n57 = new Intersections(57,42.67454000144105,-83.21512162685394);
        n57.setName("ODH Entrance");
        Intersections n58 = new Intersections(58,42.674532113430026,-83.21496069431305);
        Intersections n59 = new Intersections(59,42.674567609471815,-83.21597456932068);
        Intersections n60 = new Intersections(60,42.67500144834442,-83.21605503559113);
        Intersections n61 = new Intersections(61,42.675167095115015,-83.2156902551651);
        Intersections n62 = new Intersections(62,42.67556937829111,-83.21503043174742);
        Intersections n63 = new Intersections(63,42.67604659319167,-83.21514308452606);
        Intersections n64 = new Intersections(64,42.6762595639481,-83.21531474590302);
        Intersections n65 = new Intersections(65,42.67668155940211,-83.21543276309966);
        Intersections n66 = new Intersections(66,42.67656324320879,-83.21584045886993);
        Intersections n67 = new Intersections(67,42.676480421739406,-83.21615159511566);
        Intersections n68 = new Intersections(68,42.676701278745774,-83.21595847606658);
        n68.setName("VBH Entrance");
        Intersections n69 = new Intersections(69,42.67633055403805,-83.21549713611603);
        Intersections n70 = new Intersections(70,42.67711538351702,-83.21507334709167);
        Intersections n71 = new Intersections(71,42.67681170695459,-83.21505725383759);
        Intersections n72 = new Intersections(72,42.677012843545015,-83.21476221084595);
        Intersections n73 = new Intersections(73,42.67713115888229,-83.21446180343628);
        Intersections n74 = new Intersections(74,42.67712721504135,-83.21418285369873);
        n74.setName("HAM Entrance");
        Intersections n75 = new Intersections(75,42.677462440628304,-83.21445107460022);
        Intersections n76 = new Intersections(76,42.6778410461754,-83.21356058120726);
        Intersections n77 = new Intersections(77,42.678180211685834,-83.21278810501099);
        Intersections n78 = new Intersections(78,42.677190316466465,-83.21567416191101);
        n78.setName("VBH Entrance");
        Intersections n79 = new Intersections(79,42.677190316466465,-83.21613550186157);
        n79.setName("VBH Entrance");
        Intersections n80 = new Intersections(80,42.677348069748945,-83.2155293226242);
        Intersections n81 = new Intersections(81,42.677316519124474,-83.21522355079651);
        Intersections n82 = new Intersections(82,42.67735990122898,-83.21626961231232);
        Intersections n83 = new Intersections(83,42.67737962035738,-83.21680068969727);
        Intersections n84 = new Intersections(84,42.67755314841742,-83.21604430675507);
        Intersections n85 = new Intersections(85,42.67740328330318,-83.21603894233702);
        Intersections n86 = new Intersections(86,42.6771942603034,-83.21669340133667);
        Intersections n87 = new Intersections(87,42.67680381923188,-83.21654856204987);
        Intersections n88 = new Intersections(88,42.676701278745774,-83.21645200252533);
        Intersections n89 = new Intersections(89,42.67609786399603,-83.21643054485321);
        Intersections n90 = new Intersections(90,42.67487918496864,-83.21642518043518);
        n90.setName("OC Entrance");
        Intersections n91 = new Intersections(91,42.67528541396654,-83.21645200252533);
        Intersections n92 = new Intersections(92,42.67565614490924,-83.21560442447662);
        Intersections n93 = new Intersections(93,42.67601898581796,-83.21691870689392);
        Intersections n94 = new Intersections(94,42.675833621705365,-83.21731567382812);
        Intersections n95 = new Intersections(95,42.67612547133471,-83.21744978427887);
        Intersections n96 = new Intersections(96,42.676760436739166,-83.21699380874634);
        Intersections n97 = new Intersections(97,42.67659479421568,-83.21760535240173);
        Intersections n98 = new Intersections(98,42.67655141157705,-83.21791112422942);
        Intersections n99 = new Intersections(99,42.676665783922694,-83.21827054023743);
        n99.setName("GHC Entrance");
        Intersections n100 = new Intersections(100,42.676535636064585,-83.21856021881104);
        Intersections n101 = new Intersections(101,42.67749793499633,-83.21753561496735);
        Intersections n102 = new Intersections(102,42.67727708082139,-83.21832954883575);
        Intersections n103 = new Intersections(103,42.67717848495414,-83.21845829486847);
        Intersections n104 = new Intersections(104,42.67740722712661,-83.21884989738464);
        n104.setName("HHB Entrance");
        Intersections n105 = new Intersections(105,42.67728102465284,-83.21896255016327);
        Intersections n106 = new Intersections(106,42.6774190585954,-83.21960091590881);
        n106.setName("HHB Entrance");
        Intersections n107 = new Intersections(107,42.67599137843198,-83.21844756603241);
        Intersections n108 = new Intersections(108,42.67562853736205,-83.21844220161438);
        Intersections n109 = new Intersections(109,42.67566008884356,-83.21809887886047);
        Intersections n110 = new Intersections(110,42.67564825703987,-83.21731299161911);
        n110.setName("WH Entrance");
        Intersections n111 = new Intersections(111,42.67553979873449,-83.21790307760239);
        n111.setName("WH Entrance");
        Intersections n112 = new Intersections(112,42.675376124933486,-83.21788966655731);
        Intersections n113 = new Intersections(113,42.6753820408615,-83.21728885173798);
        Intersections n114 = new Intersections(114,42.67538795678898,-83.2184448838234);
        Intersections n115 = new Intersections(115,42.675048776038224,-83.21845293045044);
        Intersections n116 = new Intersections(116,42.675050748024695,-83.21797281503676);
        Intersections n117 = new Intersections(117,42.675044832065126,-83.21728885173798);
        Intersections n118 = new Intersections(118,42.675046804051696,-83.21682751178741);
        Intersections n119 = new Intersections(119,42.675031028157285,-83.21641445159912);
        Intersections n120 = new Intersections(120,42.67503694411815,-83.2175999879837);
        Intersections n121 = new Intersections(121,42.67485552106168,-83.21761339902878);
        n121.setName("NFH Entrance");
        Intersections n122 = new Intersections(122,42.67487326899274,-83.21798086166382);
        n122.setName("NFH Entrance");
        Intersections n123 = new Intersections(123,42.67463071349605,-83.21844220161438);
        Intersections n124 = new Intersections(124,42.67422250820584,-83.2179406285286);
        n124.setName("NFH Entrance");
        Intersections n125 = new Intersections(125,42.6742284242437,-83.21760803461075);
        n125.setName("NFH Entrance");
        Intersections n126 = new Intersections(126,42.67413573958606,-83.21780383586884);
        Intersections n127 = new Intersections(127,42.67423434028097,-83.21823835372925);
        Intersections n128 = new Intersections(128,42.67415743175235,-83.21842074394226);
        Intersections n129 = new Intersections(129,42.67407460707664,-83.21842342615128);
        Intersections n130 = new Intersections(130,42.674072635059204,-83.21799963712692);
        Intersections n131 = new Intersections(131,42.67406474698885,-83.21753829717636);
        Intersections n132 = new Intersections(132,42.673974034107744,-83.21779578924179);
        n132.setName("SFH Entrance");
        Intersections n133 = new Intersections(133,42.67391092941671,-83.21821957826614);
        Intersections n134 = new Intersections(134,42.67394050974862,-83.21749269962311);
        Intersections n135 = new Intersections(135,42.674082495145754,-83.21734786033629);
        n135.setName("OC Entrance");
        Intersections n136 = new Intersections(136,42.67390501334865,-83.21703404188156);
        n136.setName("OC Entrance");
        Intersections n137 = new Intersections(137,42.67376697160045,-83.2171842455864);
        Intersections n138 = new Intersections(138,42.67399967037017,-83.21623742580414);
        Intersections n139 = new Intersections(139,42.67311225513334,-83.21665048599243);
        n139.setName("OC Entrance");
        Intersections n140 = new Intersections(140,42.67332918002805,-83.21616500616074);
        Intersections n141 = new Intersections(141,42.673268046725234,-83.21747660636902);
        Intersections n142 = new Intersections(142,42.67300970855592,-83.21659952402115);
        Intersections n143 = new Intersections(143,42.673169444497255,-83.21638494729996);
        Intersections n144 = new Intersections(144,42.67298209983306,-83.21648150682448);
        Intersections n145 = new Intersections(145,42.67295251904498,-83.21667194366455);
        Intersections n146 = new Intersections(146,42.67305309366701,-83.21696162223816);
        Intersections n147 = new Intersections(147,42.672844056034954,-83.21653246879578);
        Intersections n148 = new Intersections(148,42.67305506571678,-83.21720838546753);
        Intersections n149 = new Intersections(149,42.67268826338019,-83.21720838546753);
        Intersections n150 = new Intersections(150,42.67270009574742,-83.21665585041046);
        Intersections n151 = new Intersections(151,42.672558107192,-83.21650296449661);
        Intersections n152 = new Intersections(152,42.672698123686374,-83.21644932031631);
        Intersections n153 = new Intersections(153,42.672853916316406,-83.21624279022217);
        Intersections n154 = new Intersections(154,42.672698123686374,-83.21604698896408);
        Intersections n155 = new Intersections(155,42.67253049826854,-83.2162669301033);
        n155.setName("KL Entrance");
        Intersections n156 = new Intersections(156,42.672565995453596,-83.21610599756241);
        Intersections n157 = new Intersections(157,42.672351039967204,-83.21642518043518);
        Intersections n158 = new Intersections(158,42.672414146242126,-83.21672022342682);
        Intersections n159 = new Intersections(159,42.67221891099654,-83.2163017988205);
        Intersections n160 = new Intersections(160,42.67228004533133,-83.21652442216873);
        Intersections n161 = new Intersections(161,42.67230568229251,-83.2166799902916);
        Intersections n162 = new Intersections(162,42.672345123750624,-83.21691066026688);
        Intersections n163 = new Intersections(163,42.67225835250972,-83.21678727865219);
        Intersections n164 = new Intersections(164,42.67210650254662,-83.21650564670563);
        Intersections n165 = new Intersections(165,42.672122279183455,-83.2167899608612);
        n165.setName("DHE Entrance");
        Intersections n166 = new Intersections(166,42.672309626439464,-83.21722447872162);
        n166.setName("DHE Entrance");
        Intersections n167 = new Intersections(167,42.67210650254662,-83.21706622838973);
        Intersections n168 = new Intersections(168,42.67219524607661,-83.21722716093062);
        Intersections n169 = new Intersections(169,42.672311598512835,-83.21760803461075);
        Intersections n170 = new Intersections(170,42.67241809038219,-83.21778237819672);
        Intersections n171 = new Intersections(171,42.67268826338019,-83.21803718805313);
        Intersections n172 = new Intersections(172,42.673003792402056,-83.21776896715164);
        Intersections n173 = new Intersections(173,42.67328185102467,-83.21779310703278);
        Intersections n174 = new Intersections(174,42.673175360635334,-83.21779310703278);
        n174.setName("SFH Entrance");
        Intersections n175 = new Intersections(175,42.67318324881859,-83.21845561265944);
        Intersections n176 = new Intersections(176,42.67398389420994,-83.21845561265944);
        Intersections n177 = new Intersections(177,42.67208283758389,-83.21782261133194);
        Intersections n178 = new Intersections(178,42.67171800160157,-83.2172378897667);
        n178.setName("HHS Entrance");
        Intersections n179 = new Intersections(179,42.671869852513844,-83.21603894233702);
        n179.setName("DHE Entrance");
        Intersections n180 = new Intersections(180,42.67165292252557,-83.21604162454605);
        Intersections n181 = new Intersections(181,42.671378800821145,-83.21598261594772);
        n181.setName("DHE Entrance");
        Intersections n182 = new Intersections(182,42.671378800821145,-83.21598261594772);
        Intersections n183 = new Intersections(183,42.67100212801785,-83.21593165397644);
        Intersections n184 = new Intersections(184,42.67132752612351,-83.21724325418472);
        Intersections n185 = new Intersections(185,42.670992267442585,-83.21725934743881);
        Intersections n186 = new Intersections(186,42.67099621167287,-83.2171869277954);
        n186.setName("SEB Entrance");
        Intersections n187 = new Intersections(187,42.670986351096694,-83.21734786033629);
        n187.setName("SEB Entrance");
        Intersections n188 = new Intersections(188,42.670779278635365,-83.2172378897667);
        Intersections n189 = new Intersections(189,42.67169236439795,-83.21733176708221);
        n189.setName("HHS Entrance");
        Intersections n190 = new Intersections(190,42.67171405741708,-83.21836441755295);
        n190.setName("HHS Entrance");
        Intersections n191 = new Intersections(191,42.670779278635365,-83.21595847606658);
        Intersections n192 = new Intersections(192,42.67076941802473,-83.21850121021271);
        Intersections n193 = new Intersections(193,42.6713255540189,-83.21843951940536);
        Intersections n194 = new Intersections(194,42.671323581914244,-83.21798086166382);
        n194.setName("SEB Entrance");
        Intersections n195 = new Intersections(195,42.67221496684386,-83.21841537952422);
        Intersections n196 = new Intersections(196,42.66901420441538,-83.21590483188629);
        Intersections n197 = new Intersections(197,42.67076547378007,-83.21685165166855);
        Intersections n198 = new Intersections(198,42.67475297736067,-83.21686506271361);
        n198.setName("OC Entrance");
        Intersections n199 = new Intersections(199,42.674985672438474,-83.2149714231491);
        Intersections n200 = new Intersections(200,42.67587306092458,-83.216392993927);

        // arrays used to store the distance calculation between two connected nodes (simulating weighted edges)
        float[] test1 = new float[3];
        float[] test2 = new float[3];
        float[] test3 = new float[3];
        float[] test4 = new float[3];
        float[] test5 = new float[3];
        float[] test6 = new float[3];
        float[] test7 = new float[3];
        float[] test8 = new float[3];
        float[] test9 = new float[3];
        float[] test10 = new float[3];
        float[] test11 = new float[3];
        float[] test12 = new float[3];
        float[] test13 = new float[3];
        float[] test14 = new float[3];
        float[] test15 = new float[3];
        float[] test16 = new float[3];
        float[] test17 = new float[3];
        float[] test18 = new float[3];
        float[] test19 = new float[3];
        float[] test20 = new float[3];
        float[] test21 = new float[3];
        float[] test22 = new float[3];
        float[] test23 = new float[3];
        float[] test24 = new float[3];
        float[] test25 = new float[3];
        float[] test26 = new float[3];
        float[] test27 = new float[3];
        float[] test28 = new float[3];
        float[] test29 = new float[3];
        float[] test30 = new float[3];
        float[] test31 = new float[3];
        float[] test32 = new float[3];
        float[] test33 = new float[3];
        float[] test34 = new float[3];
        float[] test35 = new float[3];
        float[] test36 = new float[3];
        float[] test37 = new float[3];
        float[] test38 = new float[3];
        float[] test39 = new float[3];
        float[] test40 = new float[3];
        float[] test41 = new float[3];
        float[] test42 = new float[3];
        float[] test43 = new float[3];
        float[] test44 = new float[3];
        float[] test45 = new float[3];
        float[] test46 = new float[3];
        float[] test47 = new float[3];
        float[] test48 = new float[3];
        float[] test49 = new float[3];
        float[] test50 = new float[3];
        float[] test51 = new float[3];
        float[] test52 = new float[3];
        float[] test53 = new float[3];
        float[] test54 = new float[3];
        float[] test55 = new float[3];
        float[] test56 = new float[3];
        float[] test57 = new float[3];
        float[] test58 = new float[3];
        float[] test59 = new float[3];
        float[] test60 = new float[3];
        float[] test61 = new float[3];
        float[] test62 = new float[3];
        float[] test63 = new float[3];
        float[] test64 = new float[3];
        float[] test65 = new float[3];
        float[] test66 = new float[3];
        float[] test67 = new float[3];
        float[] test68 = new float[3];
        float[] test69 = new float[3];
        float[] test70 = new float[3];
        float[] test71 = new float[3];
        float[] test72 = new float[3];
        float[] test73 = new float[3];
        float[] test74 = new float[3];
        float[] test75 = new float[3];
        float[] test76 = new float[3];
        float[] test77 = new float[3];
        float[] test78 = new float[3];
        float[] test79 = new float[3];
        float[] test80 = new float[3];
        float[] test81 = new float[3];
        float[] test82 = new float[3];
        float[] test83 = new float[3];
        float[] test84 = new float[3];
        float[] test85 = new float[3];
        float[] test86 = new float[3];
        float[] test87 = new float[3];
        float[] test88 = new float[3];
        float[] test89 = new float[3];
        float[] test90 = new float[3];
        float[] test91 = new float[3];
        float[] test92 = new float[3];
        float[] test93 = new float[3];
        float[] test94 = new float[3];
        float[] test95 = new float[3];
        float[] test96 = new float[3];
        float[] test97 = new float[3];
        float[] test98 = new float[3];
        float[] test99 = new float[3];
        float[] test100 = new float[3];
        float[] test101 = new float[3];
        float[] test102 = new float[3];
        float[] test103 = new float[3];
        float[] test104 = new float[3];
        float[] test105 = new float[3];
        float[] test106 = new float[3];
        float[] test107 = new float[3];
        float[] test108 = new float[3];
        float[] test109 = new float[3];
        float[] test110 = new float[3];
        float[] test111 = new float[3];
        float[] test112 = new float[3];
        float[] test113 = new float[3];
        float[] test114 = new float[3];
        float[] test115 = new float[3];
        float[] test116 = new float[3];
        float[] test117 = new float[3];
        float[] test118 = new float[3];
        float[] test119 = new float[3];
        float[] test120 = new float[3];
        float[] test121 = new float[3];
        float[] test122 = new float[3];
        float[] test123 = new float[3];
        float[] test124 = new float[3];
        float[] test125 = new float[3];
        float[] test126 = new float[3];
        float[] test127 = new float[3];
        float[] test128 = new float[3];
        float[] test129 = new float[3];
        float[] test130 = new float[3];
        float[] test131 = new float[3];
        float[] test132 = new float[3];
        float[] test133 = new float[3];
        float[] test134 = new float[3];
        float[] test135 = new float[3];
        float[] test136 = new float[3];
        float[] test137 = new float[3];
        float[] test138 = new float[3];
        float[] test139 = new float[3];
        float[] test140 = new float[3];
        float[] test141 = new float[3];
        float[] test142 = new float[3];
        float[] test143 = new float[3];
        float[] test144 = new float[3];
        float[] test145 = new float[3];
        float[] test146 = new float[3];
        float[] test147 = new float[3];
        float[] test148 = new float[3];
        float[] test149 = new float[3];
        float[] test150 = new float[3];
        float[] test151 = new float[3];
        float[] test152 = new float[3];
        float[] test153 = new float[3];
        float[] test154 = new float[3];
        float[] test155 = new float[3];
        float[] test156 = new float[3];
        float[] test157 = new float[3];
        float[] test158 = new float[3];
        float[] test159 = new float[3];
        float[] test160 = new float[3];
        float[] test161 = new float[3];
        float[] test162 = new float[3];
        float[] test163 = new float[3];
        float[] test164 = new float[3];
        float[] test165 = new float[3];
        float[] test166 = new float[3];
        float[] test167 = new float[3];
        float[] test168 = new float[3];
        float[] test169 = new float[3];
        float[] test170 = new float[3];
        float[] test171 = new float[3];
        float[] test172 = new float[3];
        float[] test173 = new float[3];
        float[] test174 = new float[3];
        float[] test175 = new float[3];
        float[] test176 = new float[3];
        float[] test177 = new float[3];
        float[] test178 = new float[3];
        float[] test179 = new float[3];
        float[] test180 = new float[3];
        float[] test181 = new float[3];
        float[] test182 = new float[3];
        float[] test183 = new float[3];
        float[] test184 = new float[3];
        float[] test185 = new float[3];
        float[] test186 = new float[3];
        float[] test187 = new float[3];
        float[] test188 = new float[3];
        float[] test189 = new float[3];
        float[] test190 = new float[3];
        float[] test191 = new float[3];
        float[] test192 = new float[3];
        float[] test193 = new float[3];
        float[] test194 = new float[3];
        float[] test195 = new float[3];
        float[] test196 = new float[3];
        float[] test197 = new float[3];
        float[] test198 = new float[3];
        float[] test199 = new float[3];
        float[] test200 = new float[3];
        float[] test201 = new float[3];
        float[] test202 = new float[3];
        float[] test203 = new float[3];
        float[] test204 = new float[3];
        float[] test205 = new float[3];
        float[] test206 = new float[3];
        float[] test207 = new float[3];
        float[] test208 = new float[3];
        float[] test209 = new float[3];
        float[] test210 = new float[3];
        float[] test211 = new float[3];
        float[] test212 = new float[3];
        float[] test213 = new float[3];
        float[] test214 = new float[3];
        float[] test215 = new float[3];
        float[] test216 = new float[3];
        float[] test217 = new float[3];
        float[] test218 = new float[3];
        float[] test219 = new float[3];
        float[] test220 = new float[3];
        float[] test221 = new float[3];
        float[] test222 = new float[3];
        float[] test223 = new float[3];
        float[] test224 = new float[3];
        float[] test225 = new float[3];
        float[] test226 = new float[3];
        float[] test227 = new float[3];
        float[] test228 = new float[3];
        float[] test229 = new float[3];
        float[] test230 = new float[3];
        float[] test231 = new float[3];
        float[] test232 = new float[3];
        float[] test233 = new float[3];
        float[] test234 = new float[3];
        float[] test235 = new float[3];
        float[] test236 = new float[3];
        float[] test237 = new float[3];
        float[] test238 = new float[3];
        float[] test239 = new float[3];
        float[] test240 = new float[3];
        float[] test241 = new float[3];
        float[] test242 = new float[3];
        float[] test243 = new float[3];
        float[] test244 = new float[3];
        float[] test245 = new float[3];
        float[] test246 = new float[3];
        float[] test247 = new float[3];
        float[] test248 = new float[3];
        float[] test249 = new float[3];
        float[] test250 = new float[3];
        float[] test251 = new float[3];
        float[] test252 = new float[3];
        float[] test253 = new float[3];
        float[] test254 = new float[3];
        float[] test255 = new float[3];
        float[] test256 = new float[3];
        float[] test257 = new float[3];
        float[] test258 = new float[3];
        float[] test259 = new float[3];
        float[] test260 = new float[3];
        float[] test261 = new float[3];
        float[] test262 = new float[3];
        float[] test263 = new float[3];
        float[] test264 = new float[3];
        float[] test265 = new float[3];
        float[] test266 = new float[3];
        float[] test267 = new float[3];
        float[] test268 = new float[3];
        float[] test269 = new float[3];
        float[] test270 = new float[3];
        float[] test271 = new float[3];
        float[] test272 = new float[3];
        float[] test273 = new float[3];
        float[] test274 = new float[3];
        float[] test275 = new float[3];
        float[] test276 = new float[3];
        float[] test277 = new float[3];
        float[] test278 = new float[3];
        float[] test279 = new float[3];
        float[] test280 = new float[3];
        float[] test281 = new float[3];
        float[] test282 = new float[3];

        // distanceBetween() method takes two nodes' latitude and longitude and computes the distance between them as a straight line
        distanceBetween(n1.getLat(), n1.getLon(), n2.getLat(), n2.getLon(),test1);
        distanceBetween(n2.getLat(), n2.getLon(), n3.getLat(), n3.getLon(),test2);
        distanceBetween(n3.getLat(), n3.getLon(), n4.getLat(), n4.getLon(),test3);
        distanceBetween(n4.getLat(), n4.getLon(), n5.getLat(), n5.getLon(),test4);
        distanceBetween(n5.getLat(), n5.getLon(), n6.getLat(), n6.getLon(),test5);
        distanceBetween(n5.getLat(), n5.getLon(), n7.getLat(), n7.getLon(),test6);
        distanceBetween(n7.getLat(), n7.getLon(), n8.getLat(), n8.getLon(),test7);
        distanceBetween(n8.getLat(), n8.getLon(), n9.getLat(), n9.getLon(),test8);
        distanceBetween(n9.getLat(), n9.getLon(), n10.getLat(), n10.getLon(),test9);
        distanceBetween(n10.getLat(), n10.getLon(), n11.getLat(), n11.getLon(),test10);
        distanceBetween(n11.getLat(), n11.getLon(), n12.getLat(), n12.getLon(),test11);
        distanceBetween(n12.getLat(), n12.getLon(), n13.getLat(), n13.getLon(),test12);
        distanceBetween(n12.getLat(), n12.getLon(), n15.getLat(), n15.getLon(),test13);
        distanceBetween(n12.getLat(), n12.getLon(), n58.getLat(), n58.getLon(),test14);
        distanceBetween(n12.getLat(), n12.getLon(), n199.getLat(), n199.getLon(),test15);
        distanceBetween(n13.getLat(), n13.getLon(), n14.getLat(), n14.getLon(),test16);
        distanceBetween(n15.getLat(), n15.getLon(), n14.getLat(), n14.getLon(),test17);
        distanceBetween(n14.getLat(), n14.getLon(), n16.getLat(), n16.getLon(),test18);
        distanceBetween(n14.getLat(), n14.getLon(), n56.getLat(), n56.getLon(),test19);
        distanceBetween(n15.getLat(), n15.getLon(), n17.getLat(), n17.getLon(),test20);
        distanceBetween(n16.getLat(), n16.getLon(), n17.getLat(), n17.getLon(),test21);
        distanceBetween(n16.getLat(), n16.getLon(), n18.getLat(), n18.getLon(),test22);
        distanceBetween(n17.getLat(), n17.getLon(), n19.getLat(), n19.getLon(),test23);
        distanceBetween(n18.getLat(), n18.getLon(), n20.getLat(), n20.getLon(),test24);
        distanceBetween(n18.getLat(), n18.getLon(), n28.getLat(), n28.getLon(),test25);
        distanceBetween(n19.getLat(), n19.getLon(), n20.getLat(), n20.getLon(),test26);
        distanceBetween(n19.getLat(), n19.getLon(), n21.getLat(), n21.getLon(),test27);
        distanceBetween(n20.getLat(), n20.getLon(), n32.getLat(), n32.getLon(),test28);//no
        distanceBetween(n20.getLat(), n20.getLon(), n41.getLat(), n41.getLon(),test29);
        distanceBetween(n21.getLat(), n21.getLon(), n22.getLat(), n22.getLon(),test30);
        distanceBetween(n21.getLat(), n21.getLon(), n26.getLat(), n26.getLon(),test31);
        distanceBetween(n23.getLat(), n23.getLon(), n24.getLat(), n24.getLon(),test32);
        distanceBetween(n23.getLat(), n23.getLon(), n26.getLat(), n26.getLon(),test33);
        distanceBetween(n24.getLat(), n24.getLon(), n25.getLat(), n25.getLon(),test34);
        distanceBetween(n26.getLat(), n26.getLon(), n27.getLat(), n27.getLon(),test35);
        distanceBetween(n28.getLat(), n28.getLon(), n32.getLat(), n32.getLon(),test36);
        distanceBetween(n28.getLat(), n28.getLon(), n33.getLat(), n33.getLon(),test37);
        distanceBetween(n29.getLat(), n29.getLon(), n30.getLat(), n30.getLon(),test38);
        distanceBetween(n29.getLat(), n29.getLon(), n42.getLat(), n42.getLon(),test39);
        distanceBetween(n30.getLat(), n30.getLon(), n31.getLat(), n31.getLon(),test40);
        distanceBetween(n30.getLat(), n30.getLon(), n36.getLat(), n36.getLon(),test41);
        distanceBetween(n31.getLat(), n31.getLon(), n34.getLat(), n34.getLon(),test42);
        distanceBetween(n31.getLat(), n31.getLon(), n36.getLat(), n36.getLon(),test43);
        distanceBetween(n33.getLat(), n33.getLon(), n43.getLat(), n43.getLon(),test44);
        distanceBetween(n34.getLat(), n34.getLon(), n37.getLat(), n37.getLon(),test45);
        distanceBetween(n35.getLat(), n35.getLon(), n36.getLat(), n36.getLon(),test46);
        distanceBetween(n35.getLat(), n35.getLon(), n38.getLat(), n38.getLon(),test47);
        distanceBetween(n36.getLat(), n36.getLon(), n37.getLat(), n37.getLon(),test48);
        distanceBetween(n37.getLat(), n37.getLon(), n39.getLat(), n39.getLon(),test49);
        distanceBetween(n38.getLat(), n38.getLon(), n39.getLat(), n39.getLon(),test50);
        distanceBetween(n38.getLat(), n38.getLon(), n40.getLat(), n40.getLon(),test51);
        distanceBetween(n39.getLat(), n39.getLon(), n40.getLat(), n40.getLon(),test52);
        distanceBetween(n40.getLat(), n40.getLon(), n183.getLat(), n183.getLon(),test53);
        distanceBetween(n41.getLat(), n41.getLon(), n42.getLat(), n42.getLon(),test54);
        distanceBetween(n43.getLat(), n43.getLon(), n44.getLat(), n44.getLon(),test55);
        distanceBetween(n44.getLat(), n44.getLon(), n45.getLat(), n45.getLon(),test56);
        distanceBetween(n45.getLat(), n45.getLon(), n46.getLat(), n46.getLon(),test57);
        distanceBetween(n46.getLat(), n46.getLon(), n47.getLat(), n47.getLon(),test58);
        distanceBetween(n46.getLat(), n46.getLon(), n141.getLat(), n141.getLon(),test59);
        distanceBetween(n47.getLat(), n47.getLon(), n48.getLat(), n48.getLon(),test60);
        distanceBetween(n47.getLat(), n47.getLon(), n141.getLat(), n141.getLon(),test61);
        distanceBetween(n48.getLat(), n48.getLon(), n139.getLat(), n139.getLon(),test62);
        distanceBetween(n48.getLat(), n48.getLon(), n137.getLat(), n137.getLon(),test63);
        distanceBetween(n49.getLat(),n49.getLon(),n139.getLat(),n139.getLon(),test64);
        distanceBetween(n49.getLat(),n49.getLon(),n54.getLat(),n54.getLon(),test65);
        distanceBetween(n49.getLat(),n49.getLon(),n48.getLat(),n48.getLon(),test66);
        distanceBetween(n49.getLat(), n49.getLon(), n50.getLat(), n50.getLon(),test67);
        distanceBetween(n50.getLat(), n50.getLon(), n51.getLat(), n51.getLon(),test68);
        distanceBetween(n50.getLat(), n50.getLon(), n59.getLat(), n59.getLon(),test69);
        distanceBetween(n50.getLat(), n50.getLon(), n139.getLat(), n139.getLon(),test70);
        distanceBetween(n51.getLat(), n51.getLon(), n52.getLat(), n52.getLon(),test71);
        distanceBetween(n51.getLat(), n51.getLon(), n53.getLat(), n53.getLon(),test72);
        distanceBetween(n54.getLat(), n54.getLon(), n55.getLat(), n55.getLon(),test73);
        distanceBetween(n54.getLat(), n54.getLon(), n56.getLat(), n56.getLon(),test74);
        distanceBetween(n55.getLat(), n55.getLon(), n56.getLat(), n56.getLon(),test75);
        distanceBetween(n56.getLat(), n56.getLon(), n58.getLat(), n58.getLon(),test76);
        distanceBetween(n57.getLat(), n57.getLon(), n58.getLat(), n58.getLon(),test77);
        distanceBetween(n58.getLat(), n58.getLon(), n199.getLat(), n199.getLon(),test78);
        distanceBetween(n59.getLat(), n59.getLon(), n60.getLat(), n60.getLon(),test79);
        distanceBetween(n60.getLat(), n60.getLon(), n61.getLat(), n61.getLon(),test80);
        distanceBetween(n60.getLat(), n60.getLon(), n90.getLat(), n90.getLon(),test81);
        distanceBetween(n61.getLat(), n61.getLon(), n62.getLat(), n62.getLon(),test82);
        distanceBetween(n61.getLat(), n61.getLon(), n199.getLat(), n199.getLon(),test83);
        distanceBetween(n62.getLat(), n62.getLon(), n63.getLat(), n63.getLon(),test84);
        distanceBetween(n62.getLat(), n62.getLon(), n199.getLat(), n199.getLon(),test85);
        distanceBetween(n63.getLat(), n63.getLon(), n64.getLat(), n64.getLon(),test86);
        distanceBetween(n63.getLat(), n63.getLon(), n92.getLat(), n92.getLon(),test87);
        distanceBetween(n64.getLat(), n64.getLon(), n65.getLat(), n65.getLon(),test88);
        distanceBetween(n64.getLat(), n64.getLon(), n69.getLat(), n69.getLon(),test89);
        distanceBetween(n65.getLat(), n65.getLon(), n66.getLat(), n66.getLon(),test90);
        distanceBetween(n65.getLat(), n65.getLon(), n70.getLat(), n70.getLon(),test91);
        distanceBetween(n65.getLat(), n65.getLon(), n71.getLat(), n71.getLon(),test92);
        distanceBetween(n66.getLat(), n66.getLon(), n67.getLat(), n67.getLon(),test93);
        distanceBetween(n66.getLat(), n66.getLon(), n68.getLat(), n68.getLon(),test94);
        distanceBetween(n66.getLat(), n66.getLon(), n69.getLat(), n69.getLon(),test95);
        distanceBetween(n67.getLat(), n67.getLon(), n69.getLat(), n69.getLon(),test96);
        distanceBetween(n67.getLat(), n67.getLon(), n88.getLat(), n88.getLon(),test97);
        distanceBetween(n67.getLat(), n67.getLon(), n89.getLat(), n89.getLon(),test98);
        distanceBetween(n70.getLat(), n70.getLon(), n71.getLat(), n71.getLon(),test99);
        distanceBetween(n70.getLat(), n70.getLon(), n73.getLat(), n73.getLon(),test100);
        distanceBetween(n70.getLat(), n70.getLon(), n81.getLat(), n81.getLon(),test101);
        distanceBetween(n72.getLat(), n72.getLon(), n73.getLat(), n73.getLon(),test102);
        distanceBetween(n72.getLat(), n72.getLon(), n75.getLat(), n75.getLon(),test103);
        distanceBetween(n72.getLat(), n72.getLon(), n81.getLat(), n81.getLon(),test104);
        distanceBetween(n73.getLat(), n73.getLon(), n74.getLat(), n74.getLon(),test105);
        distanceBetween(n75.getLat(), n75.getLon(), n76.getLat(), n76.getLon(),test106);
        distanceBetween(n76.getLat(), n76.getLon(), n77.getLat(), n77.getLon(),test107);
        distanceBetween(n77.getLat(), n77.getLon(), n1.getLat(), n1.getLon(),test108);
        distanceBetween(n78.getLat(), n78.getLon(), n79.getLat(), n79.getLon(),test109);
        distanceBetween(n78.getLat(), n78.getLon(), n80.getLat(), n80.getLon(),test110);
        distanceBetween(n79.getLat(), n79.getLon(), n82.getLat(), n82.getLon(),test111);
        distanceBetween(n80.getLat(), n80.getLon(), n81.getLat(), n81.getLon(),test112);
        distanceBetween(n80.getLat(), n80.getLon(), n85.getLat(), n85.getLon(),test113);
        distanceBetween(n82.getLat(), n82.getLon(), n83.getLat(), n83.getLon(),test114);
        distanceBetween(n82.getLat(), n82.getLon(), n84.getLat(), n84.getLon(),test115);
        distanceBetween(n82.getLat(), n82.getLon(), n85.getLat(), n85.getLon(),test116);
        distanceBetween(n83.getLat(), n83.getLon(), n86.getLat(), n86.getLon(),test117);
        distanceBetween(n83.getLat(), n83.getLon(), n101.getLat(), n101.getLon(),test118);
        distanceBetween(n86.getLat(), n86.getLon(), n87.getLat(), n87.getLon(),test119);
        distanceBetween(n87.getLat(), n87.getLon(), n88.getLat(), n88.getLon(),test120);
        distanceBetween(n87.getLat(), n87.getLon(), n96.getLat(), n96.getLon(),test121);
        distanceBetween(n89.getLat(), n89.getLon(), n93.getLat(), n93.getLon(),test122);
        distanceBetween(n89.getLat(), n89.getLon(), n200.getLat(), n200.getLon(),test123);
        distanceBetween(n90.getLat(), n90.getLon(), n119.getLat(), n119.getLon(),test124);
        distanceBetween(n91.getLat(), n91.getLon(), n92.getLat(), n92.getLon(),test125);
        distanceBetween(n91.getLat(), n91.getLon(), n119.getLat(), n119.getLon(),test126);
        distanceBetween(n91.getLat(), n91.getLon(), n200.getLat(), n200.getLon(),test127);
        distanceBetween(n93.getLat(), n93.getLon(), n95.getLat(), n95.getLon(),test128);
        distanceBetween(n94.getLat(), n94.getLon(), n95.getLat(), n95.getLon(),test129);
        distanceBetween(n94.getLat(), n94.getLon(), n109.getLat(), n109.getLon(),test130);
        distanceBetween(n94.getLat(), n94.getLon(), n110.getLat(), n110.getLon(),test131);
        distanceBetween(n95.getLat(), n95.getLon(), n97.getLat(), n97.getLon(),test132);
        distanceBetween(n96.getLat(), n96.getLon(), n97.getLat(), n97.getLon(),test133);
        distanceBetween(n97.getLat(), n97.getLon(), n98.getLat(), n98.getLon(),test134);
        distanceBetween(n97.getLat(), n97.getLon(), n99.getLat(), n99.getLon(),test135);
        distanceBetween(n98.getLat(), n98.getLon(), n99.getLat(), n99.getLon(),test136);
        distanceBetween(n99.getLat(), n99.getLon(), n100.getLat(), n100.getLon(),test137);
        distanceBetween(n100.getLat(), n100.getLon(), n103.getLat(), n103.getLon(),test138);
        distanceBetween(n100.getLat(), n100.getLon(), n107.getLat(), n107.getLon(),test139);
        distanceBetween(n101.getLat(), n101.getLon(), n102.getLat(), n102.getLon(),test140);
        distanceBetween(n102.getLat(), n102.getLon(), n103.getLat(), n103.getLon(),test141);
        distanceBetween(n103.getLat(), n103.getLon(), n104.getLat(), n104.getLon(),test142);
        distanceBetween(n104.getLat(), n104.getLon(), n105.getLat(), n105.getLon(),test143);
        distanceBetween(n105.getLat(), n105.getLon(), n106.getLat(), n106.getLon(),test144);
        distanceBetween(n107.getLat(), n107.getLon(), n108.getLat(), n108.getLon(),test145);
        distanceBetween(n108.getLat(), n108.getLon(), n109.getLat(), n109.getLon(),test146);
        distanceBetween(n108.getLat(), n108.getLon(), n114.getLat(), n114.getLon(),test147);
        distanceBetween(n109.getLat(), n109.getLon(), n111.getLat(), n111.getLon(),test148);
        distanceBetween(n110.getLat(), n110.getLon(), n113.getLat(), n113.getLon(),test149);
        distanceBetween(n111.getLat(), n111.getLon(), n112.getLat(), n112.getLon(),test150);
        distanceBetween(n112.getLat(), n112.getLon(), n113.getLat(), n113.getLon(),test151);
        distanceBetween(n112.getLat(), n112.getLon(), n114.getLat(), n114.getLon(),test152);
        distanceBetween(n112.getLat(), n112.getLon(), n116.getLat(), n116.getLon(),test153);
        distanceBetween(n113.getLat(), n113.getLon(), n117.getLat(), n117.getLon(),test154);
        distanceBetween(n114.getLat(), n114.getLon(), n115.getLat(), n115.getLon(),test155);
        distanceBetween(n115.getLat(), n115.getLon(), n116.getLat(), n116.getLon(),test156);
        distanceBetween(n115.getLat(), n115.getLon(), n123.getLat(), n123.getLon(),test157);
        distanceBetween(n116.getLat(), n116.getLon(), n120.getLat(), n120.getLon(),test158);
        distanceBetween(n116.getLat(), n116.getLon(), n122.getLat(), n122.getLon(),test159);
        distanceBetween(n117.getLat(), n117.getLon(), n118.getLat(), n118.getLon(),test160);
        distanceBetween(n117.getLat(), n117.getLon(), n120.getLat(), n120.getLon(),test161);
        distanceBetween(n118.getLat(), n118.getLon(), n119.getLat(), n119.getLon(),test162);
        distanceBetween(n118.getLat(), n118.getLon(), n198.getLat(), n198.getLon(),test163);
        distanceBetween(n120.getLat(), n120.getLon(), n121.getLat(), n121.getLon(),test164);
        distanceBetween(n123.getLat(), n123.getLon(), n124.getLat(), n124.getLon(),test165);
        distanceBetween(n129.getLat(), n129.getLon(), n177.getLat(), n177.getLon(),test166);
        distanceBetween(n124.getLat(), n124.getLon(), n126.getLat(), n126.getLon(),test167);
        distanceBetween(n124.getLat(), n124.getLon(), n130.getLat(), n130.getLon(),test168);
        distanceBetween(n125.getLat(), n125.getLon(), n126.getLat(), n126.getLon(),test169);
        distanceBetween(n125.getLat(), n125.getLon(), n131.getLat(), n131.getLon(),test170);
        distanceBetween(n126.getLat(), n126.getLon(), n130.getLat(), n130.getLon(),test171);
        distanceBetween(n126.getLat(), n126.getLon(), n131.getLat(), n131.getLon(),test172);
        distanceBetween(n126.getLat(), n126.getLon(), n132.getLat(), n132.getLon(),test173);
        distanceBetween(n127.getLat(), n127.getLon(), n128.getLat(), n128.getLon(),test174);
        distanceBetween(n127.getLat(), n127.getLon(), n130.getLat(), n130.getLon(),test175);
        distanceBetween(n128.getLat(), n128.getLon(), n129.getLat(), n129.getLon(),test176);
        distanceBetween(n129.getLat(), n129.getLon(), n130.getLat(), n130.getLon(),test177);
        distanceBetween(n130.getLat(), n130.getLon(), n133.getLat(), n133.getLon(),test178);
        distanceBetween(n131.getLat(), n131.getLon(), n134.getLat(), n134.getLon(),test179);
        distanceBetween(n131.getLat(), n131.getLon(), n135.getLat(), n135.getLon(),test180);
        distanceBetween(n132.getLat(), n132.getLon(), n134.getLat(), n134.getLon(),test181);
        distanceBetween(n134.getLat(), n134.getLon(), n135.getLat(), n135.getLon(),test182);
        distanceBetween(n134.getLat(), n134.getLon(), n138.getLat(), n138.getLon(),test183);
        distanceBetween(n136.getLat(), n136.getLon(), n138.getLat(), n138.getLon(),test184);
        distanceBetween(n137.getLat(), n137.getLon(), n136.getLat(), n136.getLon(),test185);
        distanceBetween(n137.getLat(), n137.getLon(), n138.getLat(), n138.getLon(),test186);
        distanceBetween(n137.getLat(), n137.getLon(), n140.getLat(), n140.getLon(),test187);
        distanceBetween(n138.getLat(), n138.getLon(), n142.getLat(), n142.getLon(),test188);
        distanceBetween(n140.getLat(), n140.getLon(), n143.getLat(), n143.getLon(),test189);
        distanceBetween(n140.getLat(), n140.getLon(), n144.getLat(), n144.getLon(),test190);
        distanceBetween(n140.getLat(), n140.getLon(), n147.getLat(), n147.getLon(),test191);
        distanceBetween(n141.getLat(), n141.getLon(), n144.getLat(), n144.getLon(),test192);
        distanceBetween(n142.getLat(), n142.getLon(), n173.getLat(), n173.getLon(),test193);
        distanceBetween(n142.getLat(), n142.getLon(), n175.getLat(), n175.getLon(),test194);
        distanceBetween(n143.getLat(), n143.getLon(), n145.getLat(), n145.getLon(),test195);
        distanceBetween(n143.getLat(), n143.getLon(), n146.getLat(), n146.getLon(),test196);
        distanceBetween(n144.getLat(), n144.getLon(), n145.getLat(), n145.getLon(),test197);
        distanceBetween(n145.getLat(), n145.getLon(), n148.getLat(), n148.getLon(),test198);
        distanceBetween(n146.getLat(), n146.getLon(), n147.getLat(), n147.getLon(),test199);
        distanceBetween(n146.getLat(), n146.getLon(), n148.getLat(), n148.getLon(),test200);
        distanceBetween(n147.getLat(), n147.getLon(), n149.getLat(), n149.getLon(),test201);
        distanceBetween(n148.getLat(), n148.getLon(), n151.getLat(), n151.getLon(),test202);
        distanceBetween(n148.getLat(), n148.getLon(), n153.getLat(), n153.getLon(),test203);
        distanceBetween(n148.getLat(), n148.getLon(), n154.getLat(), n154.getLon(),test204);
        distanceBetween(n149.getLat(), n149.getLon(), n142.getLat(), n142.getLon(),test205);
        distanceBetween(n149.getLat(), n149.getLon(), n173.getLat(), n173.getLon(),test206);
        distanceBetween(n150.getLat(), n150.getLon(), n146.getLat(), n146.getLon(),test207);
        distanceBetween(n150.getLat(), n150.getLon(), n149.getLat(), n149.getLon(),test208);
        distanceBetween(n150.getLat(), n150.getLon(), n151.getLat(), n151.getLon(),test209);
        distanceBetween(n150.getLat(), n150.getLon(), n159.getLat(), n159.getLon(),test210);
        distanceBetween(n150.getLat(), n150.getLon(), n167.getLat(), n167.getLon(),test211);
        distanceBetween(n150.getLat(), n150.getLon(), n171.getLat(), n171.getLon(),test212);
        distanceBetween(n150.getLat(), n150.getLon(), n172.getLat(), n172.getLon(),test213);
        distanceBetween(n150.getLat(), n150.getLon(), n173.getLat(), n173.getLon(),test214);
        distanceBetween(n151.getLat(), n151.getLon(), n152.getLat(), n152.getLon(),test215);
        distanceBetween(n152.getLat(), n152.getLon(), n153.getLat(), n153.getLon(),test216);
        distanceBetween(n152.getLat(), n152.getLon(), n156.getLat(), n156.getLon(),test217);
        distanceBetween(n152.getLat(), n152.getLon(), n158.getLat(), n158.getLon(),test218);
        distanceBetween(n153.getLat(), n153.getLon(), n155.getLat(), n155.getLon(),test219);
        distanceBetween(n154.getLat(), n154.getLon(), n155.getLat(), n155.getLon(),test220);
        distanceBetween(n155.getLat(), n155.getLon(), n157.getLat(), n157.getLon(),test221);
        distanceBetween(n156.getLat(), n156.getLon(), n157.getLat(), n157.getLon(),test222);
        distanceBetween(n157.getLat(), n157.getLon(), n160.getLat(), n160.getLon(),test223);
        distanceBetween(n158.getLat(), n158.getLon(), n160.getLat(), n160.getLon(),test224);
        distanceBetween(n158.getLat(), n158.getLon(), n161.getLat(), n161.getLon(),test225);
        distanceBetween(n152.getLat(), n152.getLon(), n159.getLat(), n159.getLon(),test226);
        distanceBetween(n159.getLat(), n159.getLon(), n162.getLat(), n162.getLon(),test227);
        distanceBetween(n159.getLat(), n159.getLon(), n163.getLat(), n163.getLon(),test228);
        distanceBetween(n160.getLat(), n160.getLon(), n180.getLat(), n180.getLon(),test229);
        distanceBetween(n160.getLat(), n160.getLon(), n165.getLat(), n165.getLon(),test230);
        distanceBetween(n161.getLat(), n161.getLon(), n162.getLat(), n162.getLon(),test231);
        distanceBetween(n161.getLat(), n161.getLon(), n165.getLat(), n165.getLon(),test232);
        distanceBetween(n162.getLat(), n162.getLon(), n164.getLat(), n164.getLon(),test233);
        distanceBetween(n163.getLat(), n163.getLon(), n164.getLat(), n164.getLon(),test234);
        distanceBetween(n163.getLat(), n163.getLon(), n167.getLat(), n167.getLon(),test235);
        distanceBetween(n164.getLat(), n164.getLon(), n166.getLat(), n166.getLon(),test236);
        distanceBetween(n165.getLat(), n165.getLon(), n166.getLat(), n166.getLon(),test237);
        distanceBetween(n166.getLat(), n166.getLon(), n168.getLat(), n168.getLon(),test238);
        distanceBetween(n167.getLat(), n167.getLon(), n169.getLat(), n169.getLon(),test239);
        distanceBetween(n167.getLat(), n167.getLon(), n170.getLat(), n170.getLon(),test240);
        distanceBetween(n168.getLat(), n168.getLon(), n169.getLat(), n169.getLon(),test241);
        distanceBetween(n168.getLat(), n168.getLon(), n179.getLat(), n179.getLon(),test242);
        distanceBetween(n184.getLat(), n184.getLon(), n179.getLat(), n179.getLon(),test243);
        distanceBetween(n189.getLat(), n189.getLon(), n179.getLat(), n179.getLon(),test244);
        distanceBetween(n170.getLat(), n170.getLon(), n171.getLat(), n171.getLon(),test245);
        distanceBetween(n170.getLat(), n170.getLon(), n178.getLat(), n178.getLon(),test246);
        distanceBetween(n171.getLat(), n171.getLon(), n172.getLat(), n172.getLon(),test247);
        distanceBetween(n171.getLat(), n171.getLon(), n178.getLat(), n178.getLon(),test248);
        distanceBetween(n172.getLat(), n172.getLon(), n173.getLat(), n173.getLon(),test249);
        distanceBetween(n172.getLat(), n172.getLon(), n195.getLat(), n195.getLon(),test250);
        distanceBetween(n172.getLat(), n172.getLon(), n176.getLat(), n176.getLon(),test251);
        distanceBetween(n173.getLat(), n173.getLon(), n175.getLat(), n175.getLon(),test252);
        distanceBetween(n174.getLat(), n174.getLon(), n175.getLat(), n175.getLon(),test253);
        distanceBetween(n175.getLat(), n175.getLon(), n176.getLat(), n176.getLon(),test254);
        distanceBetween(n195.getLat(), n195.getLon(), n178.getLat(), n178.getLon(),test255);
        distanceBetween(n180.getLat(), n180.getLon(), n181.getLat(), n181.getLon(),test256);
        distanceBetween(n182.getLat(), n182.getLon(), n181.getLat(), n181.getLon(),test257);
        distanceBetween(n183.getLat(), n183.getLon(), n182.getLat(), n182.getLon(),test258);
        distanceBetween(n191.getLat(), n191.getLon(), n183.getLat(), n183.getLon(),test259);
        distanceBetween(n185.getLat(), n185.getLon(), n184.getLat(), n184.getLon(),test260);
        distanceBetween(n186.getLat(), n186.getLon(), n185.getLat(), n185.getLon(),test261);
        distanceBetween(n189.getLat(), n189.getLon(), n184.getLat(), n184.getLon(),test262);
        distanceBetween(n187.getLat(), n187.getLon(), n185.getLat(), n185.getLon(),test263);
        distanceBetween(n188.getLat(), n188.getLon(), n185.getLat(), n185.getLon(),test264);
        distanceBetween(n188.getLat(), n188.getLon(), n197.getLat(), n197.getLon(),test265);
        distanceBetween(n192.getLat(), n192.getLon(), n188.getLat(), n188.getLon(),test266);
        distanceBetween(n192.getLat(), n192.getLon(), n193.getLat(), n193.getLon(),test267);
        distanceBetween(n194.getLat(), n194.getLon(), n193.getLat(), n193.getLon(),test268);
        distanceBetween(n190.getLat(), n190.getLon(), n195.getLat(), n195.getLon(),test269);
        distanceBetween(n193.getLat(), n193.getLon(), n190.getLat(), n190.getLon(),test270);
        distanceBetween(n191.getLat(), n191.getLon(), n196.getLat(), n196.getLon(),test271);
        distanceBetween(n197.getLat(), n197.getLon(), n191.getLat(), n191.getLon(),test272);
        distanceBetween(n117.getLat(), n117.getLon(), n198.getLat(), n198.getLon(),test273);
        distanceBetween(n123.getLat(), n123.getLon(), n128.getLat(), n128.getLon(),test274);
        distanceBetween(n177.getLat(), n177.getLon(), n129.getLat(), n129.getLon(),test275);
        distanceBetween(n130.getLat(), n130.getLon(), n132.getLat(), n132.getLon(),test276);
        distanceBetween(n177.getLat(), n177.getLon(), n133.getLat(), n133.getLon(),test277);
        distanceBetween(n176.getLat(), n176.getLon(), n177.getLat(), n177.getLon(),test278);
        distanceBetween(n184.getLat(), n184.getLon(), n179.getLat(), n179.getLon(),test279);
        distanceBetween(n200.getLat(), n200.getLon(), n93.getLat(), n93.getLon(),test280);
        distanceBetween(n200.getLat(), n200.getLon(), n92.getLat(), n92.getLon(),test281);
        distanceBetween(n139.getLat(), n139.getLon(), n54.getLat(), n54.getLon(),test282);

        // Paths objects have each edge information (to, from, distanceBetween)
        Paths pt1 = new Paths(2,1,test1[0]);
        Paths pt2 = new Paths(77,1,test108[0]);
        Paths pt3 = new Paths(1,2,test1[0]);
        Paths pt4 = new Paths(3,2,test2[0]);
        Paths pt5 = new Paths(2,3,test2[0]);
        Paths pt6 = new Paths(4,3,test3[0]);
        Paths pt7 = new Paths(3,4,test3[0]);
        Paths pt8 = new Paths(5,4,test4[0]);
        Paths pt9 = new Paths(4,5,test4[0]);
        Paths pt10 = new Paths(6,5,test5[0]);
        Paths pt11 = new Paths(7,5,test6[0]);
        Paths pt12 = new Paths(5,6,test5[0]);
        Paths pt13 = new Paths(5,7,test6[0]);
        Paths pt14 = new Paths(8,7,test7[0]);
        Paths pt15 = new Paths(7,8,test7[0]);
        Paths pt16 = new Paths(9,8,test8[0]);
        Paths pt17 = new Paths(8,9,test8[0]);
        Paths pt18 = new Paths(10,9,test9[0]);
        Paths pt19 = new Paths(9,10,test9[0]);
        Paths pt20 = new Paths(11,10,test10[0]);
        Paths pt21 = new Paths(10,11,test10[0]);
        Paths pt22 = new Paths(12,11,test11[0]);
        Paths pt23 = new Paths(11,12,test11[0]);
        Paths pt24 = new Paths(13,12,test12[0]);
        Paths pt25 = new Paths(15,12,test13[0]);
        Paths pt26 = new Paths(58,12,test14[0]);
        Paths pt27 = new Paths(199,12,test15[0]);
        Paths pt28 = new Paths(12,13,test12[0]);
        Paths pt29 = new Paths(14,13,test16[0]);
        Paths pt30 = new Paths(13,14,test16[0]);
        Paths pt31 = new Paths(15,14,test17[0]);
        Paths pt32 = new Paths(16,14,test18[0]);
        Paths pt33 = new Paths(56,14,test19[0]);
        Paths pt34 = new Paths(12,15,test13[0]);
        Paths pt35 = new Paths(14,15,test17[0]);
        Paths pt36 = new Paths(17,15,test20[0]);
        Paths pt37 = new Paths(14,16,test18[0]);
        Paths pt38 = new Paths(17,16,test21[0]);
        Paths pt39 = new Paths(18,16,test22[0]);
        Paths pt40 = new Paths(15,17,test20[0]);
        Paths pt41 = new Paths(16,17,test21[0]);
        Paths pt42 = new Paths(19,17,test23[0]);
        Paths pt43 = new Paths(16,18,test22[0]);
        Paths pt44 = new Paths(20,18,test24[0]);
        Paths pt45 = new Paths(28,18,test25[0]);
        Paths pt46 = new Paths(17,19,test23[0]);
        Paths pt47 = new Paths(20,19,test26[0]);
        Paths pt48 = new Paths(21,19,test27[0]);
        Paths pt49 = new Paths(18,20,test24[0]);
        Paths pt50 = new Paths(19,20,test26[0]);
        Paths pt51 = new Paths(41,20,test29[0]);
        Paths pt52 = new Paths(19,21,test27[0]);
        Paths pt53 = new Paths(22,21,test30[0]);
        Paths pt54 = new Paths(26,21,test31[0]);
        Paths pt55 = new Paths(21,22,test30[0]);
        Paths pt56 = new Paths(24,23,test32[0]);
        Paths pt57 = new Paths(26,23,test33[0]);
        Paths pt58 = new Paths(23,24,test32[0]);
        Paths pt59 = new Paths(25,24,test34[0]);
        Paths pt60 = new Paths(24,25,test34[0]);
        Paths pt61 = new Paths(23,26,test33[0]);
        Paths pt62 = new Paths(21,26,test31[0]);
        Paths pt63 = new Paths(27,26,test35[0]);
        Paths pt64 = new Paths(26,27,test35[0]);
        Paths pt65 = new Paths(18,28,test25[0]);
        Paths pt66 = new Paths(32,28,test36[0]);
        Paths pt67 = new Paths(33,28,test37[0]);
        Paths pt68 = new Paths(30,29,test38[0]);
        Paths pt69 = new Paths(42,29,test39[0]);
        Paths pt70 = new Paths(29,30,test38[0]);
        Paths pt71 = new Paths(31,30,test40[0]);
        Paths pt72 = new Paths(36,30,test41[0]);//**
        Paths pt73 = new Paths(30,31,test40[0]);
        Paths pt74 = new Paths(34,31,test42[0]);
        Paths pt75 = new Paths(36,31,test43[0]);
        Paths pt76 = new Paths(28,32,test36[0]);
        Paths pt77 = new Paths(28,33,test37[0]);
        Paths pt78 = new Paths(43,33,test44[0]);
        Paths pt79 = new Paths(31,34,test42[0]);
        Paths pt80 = new Paths(37,34,test45[0]);
        Paths pt81 = new Paths(36,35,test46[0]);
        Paths pt82 = new Paths(38,35,test47[0]);
        Paths pt83 = new Paths(30,36,test41[0]);//**
        Paths pt84 = new Paths(31,36,test43[0]);
        Paths pt85 = new Paths(35,36,test46[0]);
        Paths pt86 = new Paths(37,36,test48[0]);//**
        Paths pt87 = new Paths(34,37,test45[0]);
        Paths pt88 = new Paths(36,37,test48[0]);//**
        Paths pt89 = new Paths(39,37,test49[0]);
        Paths pt90 = new Paths(35,38,test47[0]);
        Paths pt91 = new Paths(39,38,test50[0]);
        Paths pt92 = new Paths(40,38,test51[0]);//**
        Paths pt93 = new Paths(37,39,test49[0]);
        Paths pt94 = new Paths(38,39,test50[0]);
        Paths pt95 = new Paths(40,39,test52[0]);
        Paths pt96 = new Paths(38,40,test51[0]);//**
        Paths pt97 = new Paths(39,40,test52[0]);
        Paths pt98 = new Paths(183,40,test53[0]);
        Paths pt99 = new Paths(20,41,test29[0]);
        Paths pt100 = new Paths(42,41,test54[0]);
        Paths pt101 = new Paths(29,42,test39[0]);
        Paths pt102 = new Paths(41,42,test54[0]);
        Paths pt103 = new Paths(33,43,test44[0]);
        Paths pt104 = new Paths(44,43,test55[0]);
        Paths pt105 = new Paths(43,44,test55[0]);
        Paths pt106 = new Paths(45,44,test56[0]);
        Paths pt107 = new Paths(44,45,test56[0]);
        Paths pt108 = new Paths(46,45,test57[0]);
        Paths pt109 = new Paths(45,46,test57[0]);
        Paths pt110 = new Paths(47,46,test58[0]);//**
        Paths pt111 = new Paths(141,46,test59[0]);
        Paths pt112 = new Paths(46,47,test58[0]);//**
        Paths pt113 = new Paths(48,47,test60[0]);
        Paths pt114 = new Paths(141,47,test61[0]);
        Paths pt115 = new Paths(47,48,test60[0]);
        Paths pt116 = new Paths(49,48,test66[0]);
        Paths pt117 = new Paths(137,48,test63[0]);
        Paths pt118 = new Paths(139,48,test62[0]);
        Paths pt119 = new Paths(48,49,test66[0]);
        Paths pt120 = new Paths(139,49,test64[0]);//**
        Paths pt121 = new Paths(50,49,test67[0]);
        Paths pt122 = new Paths(54,49,test65[0]);
        Paths pt123 = new Paths(49,50,test67[0]);
        Paths pt124 = new Paths(51,50,test68[0]);
        Paths pt125 = new Paths(59,50,test69[0]);
        Paths pt126 = new Paths(139,50,test70[0]);
        Paths pt127 = new Paths(50,51,test68[0]);
        Paths pt128 = new Paths(52,51,test71[0]);
        Paths pt129 = new Paths(53,51,test72[0]);
        Paths pt130 = new Paths(51,52,test71[0]);
        Paths pt131 = new Paths(51,53,test72[0]);
        Paths pt132 = new Paths(49,54,test65[0]);
        Paths pt133 = new Paths(55,54,test73[0]);
        Paths pt134 = new Paths(56,54,test74[0]);//**
        Paths pt135 = new Paths(54,55,test73[0]);
        Paths pt136 = new Paths(56,55,test75[0]);
        Paths pt137 = new Paths(14,56,test19[0]);
        Paths pt138 = new Paths(54,56,test74[0]);//**
        Paths pt139 = new Paths(55,56,test75[0]);
        Paths pt140 = new Paths(58,56,test76[0]);
        Paths pt141 = new Paths(58,57,test77[0]);
        Paths pt142 = new Paths(12,58,test14[0]);
        Paths pt143 = new Paths(56,58,test76[0]);
        Paths pt144 = new Paths(57,58,test77[0]);
        Paths pt145 = new Paths(199,58,test78[0]);
        Paths pt146 = new Paths(50,59,test69[0]);
        Paths pt147 = new Paths(60,59,test79[0]);
        Paths pt148 = new Paths(59,60,test79[0]);
        Paths pt149 = new Paths(61,60,test80[0]);
        Paths pt150 = new Paths(90,60,test81[0]);
        Paths pt151 = new Paths(60,61,test80[0]);
        Paths pt152 = new Paths(62,61,test82[0]);
        Paths pt153 = new Paths(199,61,test83[0]);
        Paths pt154 = new Paths(61,62,test82[0]);
        Paths pt155 = new Paths(63,62,test84[0]);
        Paths pt156 = new Paths(199,62,test85[0]);
        Paths pt157 = new Paths(62,63,test84[0]);
        Paths pt158 = new Paths(64,63,test86[0]);
        Paths pt159 = new Paths(92,63,test87[0]);
        Paths pt160 = new Paths(63,64,test86[0]);
        Paths pt161 = new Paths(65,64,test88[0]);
        Paths pt162 = new Paths(69,64,test89[0]);
        Paths pt163 = new Paths(64,65,test88[0]);
        Paths pt164 = new Paths(66,65,test90[0]);
        Paths pt165 = new Paths(70,65,test91[0]);
        Paths pt166 = new Paths(71,65,test92[0]);//**
        Paths pt167 = new Paths(65,66,test90[0]);
        Paths pt168 = new Paths(67,66,test93[0]);
        Paths pt169 = new Paths(68,66,test94[0]);
        Paths pt170 = new Paths(69,66,test95[0]);
        Paths pt171 = new Paths(66,67,test93[0]);
        Paths pt172 = new Paths(69,67,test96[0]);
        Paths pt173 = new Paths(88,67,test97[0]);
        Paths pt174 = new Paths(89,67,test98[0]);
        Paths pt175 = new Paths(66,68,test94[0]);
        Paths pt176 = new Paths(64,69,test89[0]);
        Paths pt177 = new Paths(66,69,test95[0]);
        Paths pt178 = new Paths(67,69,test96[0]);
        Paths pt179 = new Paths(65,70,test91[0]);
        Paths pt180 = new Paths(71,70,test99[0]);
        Paths pt181 = new Paths(73,70,test100[0]);//**
        Paths pt182 = new Paths(81,70,test101[0]);
        Paths pt183 = new Paths(65,71,test92[0]);//**
        Paths pt184 = new Paths(70,71,test99[0]);
        Paths pt185 = new Paths(73,72,test102[0]);
        Paths pt186 = new Paths(75,72,test103[0]);
        Paths pt187 = new Paths(81,72,test104[0]);
        Paths pt188 = new Paths(70,73,test100[0]);//**
        Paths pt189 = new Paths(72,73,test102[0]);
        Paths pt190 = new Paths(74,73,test105[0]);
        Paths pt191 = new Paths(73,74,test105[0]);
        Paths pt192 = new Paths(72,75,test103[0]);
        Paths pt193 = new Paths(76,75,test106[0]);
        Paths pt194 = new Paths(75,76,test106[0]);
        Paths pt195 = new Paths(77,76,test107[0]);
        Paths pt196 = new Paths(1,77,test108[0]);
        Paths pt197 = new Paths(76,77,test107[0]);
        Paths pt198 = new Paths(79,78,test109[0]);
        Paths pt199 = new Paths(80,78,test110[0]);
        Paths pt200 = new Paths(78,79,test109[0]);
        Paths pt201 = new Paths(82,79,test111[0]);
        Paths pt202 = new Paths(78,80,test110[0]);
        Paths pt203 = new Paths(81,80,test112[0]);
        Paths pt204 = new Paths(85,80,test113[0]);
        Paths pt205 = new Paths(70,81,test101[0]);
        Paths pt206 = new Paths(72,81,test104[0]);
        Paths pt207 = new Paths(80,81,test112[0]);
        Paths pt208 = new Paths(79,82,test111[0]);
        Paths pt209 = new Paths(83,82,test114[0]);
        Paths pt210 = new Paths(84,82,test115[0]);
        Paths pt211 = new Paths(85,82,test116[0]);
        Paths pt212 = new Paths(82,83,test114[0]);
        Paths pt213 = new Paths(86,83,test117[0]);
        Paths pt214 = new Paths(101,83,test118[0]);
        Paths pt215 = new Paths(82,84,test115[0]);
        Paths pt216 = new Paths(80,85,test113[0]);
        Paths pt217 = new Paths(82,85,test116[0]);
        Paths pt218 = new Paths(83,86,test117[0]);
        Paths pt219 = new Paths(87,86,test119[0]);
        Paths pt220 = new Paths(86,87,test119[0]);
        Paths pt221 = new Paths(88,87,test120[0]);
        Paths pt222 = new Paths(96,87,test121[0]);
        Paths pt223 = new Paths(67,88,test97[0]);
        Paths pt224 = new Paths(87,88,test120[0]);
        Paths pt225 = new Paths(67,89,test98[0]);
        Paths pt226 = new Paths(93,89,test122[0]);
        Paths pt227 = new Paths(200,89,test123[0]);
        Paths pt228 = new Paths(60,90,test81[0]);
        Paths pt229 = new Paths(119,90,test124[0]);
        Paths pt230 = new Paths(92,91,test125[0]);
        Paths pt231 = new Paths(119,91,test126[0]);
        Paths pt232 = new Paths(200,91,test127[0]);
        Paths pt233 = new Paths(63,92,test87[0]);
        Paths pt234 = new Paths(91,92,test125[0]);
        Paths pt235 = new Paths(200,92,test281[0]);
        Paths pt236 = new Paths(89,93,test122[0]);
        Paths pt237 = new Paths(95,93,test128[0]);
        Paths pt238 = new Paths(200,93,test280[0]);
        Paths pt239 = new Paths(95,94,test129[0]);
        Paths pt240 = new Paths(109,94,test130[0]);
        Paths pt241 = new Paths(110,94,test131[0]);
        Paths pt242 = new Paths(93,95,test128[0]);
        Paths pt243 = new Paths(94,95,test129[0]);
        Paths pt244 = new Paths(97,95,test132[0]);
        Paths pt245 = new Paths(87,96,test121[0]);
        Paths pt246 = new Paths(97,96,test133[0]);
        Paths pt247 = new Paths(95,97,test132[0]);
        Paths pt248 = new Paths(96,97,test133[0]);
        Paths pt249 = new Paths(98,97,test134[0]);
        Paths pt250 = new Paths(99,97,test135[0]);
        Paths pt251 = new Paths(97,98,test134[0]);
        Paths pt252 = new Paths(99,98,test136[0]);//**
        Paths pt253 = new Paths(97,99,test135[0]);
        Paths pt254 = new Paths(98,99,test136[0]);//**
        Paths pt255 = new Paths(100,99,test137[0]);
        Paths pt256 = new Paths(99,100,test137[0]);
        Paths pt257 = new Paths(103,100,test138[0]);
        Paths pt258 = new Paths(107,100,test139[0]);
        Paths pt259 = new Paths(83,101,test118[0]);
        Paths pt260 = new Paths(102,101,test140[0]);
        Paths pt261 = new Paths(101,102,test140[0]);
        Paths pt262 = new Paths(103,102,test141[0]);
        Paths pt263 = new Paths(100,103,test138[0]);
        Paths pt264 = new Paths(102,103,test141[0]);
        Paths pt265 = new Paths(104,103,test142[0]);
        Paths pt266 = new Paths(103,104,test142[0]);
        Paths pt267 = new Paths(105,104,test143[0]);
        Paths pt268 = new Paths(104,105,test143[0]);
        Paths pt269 = new Paths(106,105,test144[0]);
        Paths pt270 = new Paths(105,106,test144[0]);
        Paths pt271 = new Paths(100,107,test139[0]);
        Paths pt272 = new Paths(108,107,test145[0]);
        Paths pt273 = new Paths(107,108,test145[0]);
        Paths pt274 = new Paths(109,108,test146[0]);
        Paths pt275 = new Paths(114,108,test147[0]);
        Paths pt276 = new Paths(94,109,test130[0]);
        Paths pt277 = new Paths(108,109,test146[0]);
        Paths pt278 = new Paths(111,109,test148[0]);
        Paths pt279 = new Paths(94,110,test131[0]);
        Paths pt280 = new Paths(113,110,test149[0]);
        Paths pt281 = new Paths(109,111,test148[0]);
        Paths pt282 = new Paths(112,111,test150[0]);
        Paths pt283 = new Paths(111,112,test150[0]);
        Paths pt284 = new Paths(113,112,test151[0]);
        Paths pt285 = new Paths(114,112,test152[0]);
        Paths pt286 = new Paths(116,112,test153[0]);
        Paths pt287 = new Paths(110,113,test149[0]);
        Paths pt288 = new Paths(112,113,test151[0]);
        Paths pt289 = new Paths(117,113,test154[0]);
        Paths pt290 = new Paths(108,114,test147[0]);
        Paths pt291 = new Paths(112,114,test152[0]);
        Paths pt292 = new Paths(115,114,test155[0]);
        Paths pt293 = new Paths(114,115,test155[0]);
        Paths pt294 = new Paths(116,115,test156[0]);
        Paths pt295 = new Paths(123,115,test157[0]);
        Paths pt296 = new Paths(112,116,test153[0]);
        Paths pt297 = new Paths(115,116,test156[0]);
        Paths pt298 = new Paths(120,116,test158[0]);
        Paths pt299 = new Paths(122,116,test159[0]);
        Paths pt300 = new Paths(113,117,test154[0]);
        Paths pt301 = new Paths(118,117,test160[0]);
        Paths pt302 = new Paths(120,117,test161[0]);
        Paths pt303 = new Paths(198,117,test273[0]);
        Paths pt304 = new Paths(117,118,test160[0]);
        Paths pt305 = new Paths(119,118,test162[0]);
        Paths pt306 = new Paths(198,118,test163[0]);
        Paths pt307 = new Paths(90,119,test124[0]);
        Paths pt308 = new Paths(91,119,test126[0]);
        Paths pt309 = new Paths(118,119,test162[0]);
        Paths pt310 = new Paths(116,120,test158[0]);
        Paths pt311 = new Paths(117,120,test161[0]);
        Paths pt312 = new Paths(121,120,test164[0]);
        Paths pt313 = new Paths(120,121,test164[0]);
        Paths pt314 = new Paths(116,122,test159[0]);
        Paths pt315 = new Paths(115,123,test157[0]);
        Paths pt316 = new Paths(124,123,test165[0]);
        Paths pt317 = new Paths(128,123,test274[0]);
        Paths pt318 = new Paths(123,124,test165[0]);
        Paths pt319 = new Paths(126,124,test167[0]);
        Paths pt320 = new Paths(130,124,test168[0]);
        Paths pt321 = new Paths(126,125,test169[0]);
        Paths pt322 = new Paths(131,125,test170[0]);
        Paths pt323 = new Paths(124,126,test167[0]);
        Paths pt324 = new Paths(125,126,test169[0]);
        Paths pt325 = new Paths(130,126,test171[0]);//**
        Paths pt326 = new Paths(131,126,test172[0]);//**
        Paths pt327 = new Paths(132,126,test173[0]);
        Paths pt328 = new Paths(128,127,test174[0]);
        Paths pt329 = new Paths(130,127,test175[0]);
        Paths pt330 = new Paths(127,128,test174[0]);
        Paths pt331 = new Paths(129,128,test176[0]);
        Paths pt332 = new Paths(123,128,test274[0]);
        Paths pt333 = new Paths(177,129,test275[0]);
        Paths pt334 = new Paths(128,129,test176[0]);
        Paths pt335 = new Paths(130,129,test177[0]);//**
        Paths pt336 = new Paths(124,130,test168[0]);
        Paths pt337 = new Paths(126,130,test171[0]);//**
        Paths pt338 = new Paths(127,130,test175[0]);
        Paths pt339 = new Paths(129,130,test177[0]);//**
        Paths pt340 = new Paths(133,130,test178[0]);
        Paths pt341 = new Paths(132,130,test276[0]);
        Paths pt342 = new Paths(125,131,test170[0]);
        Paths pt343 = new Paths(126,131,test172[0]);//**
        Paths pt344 = new Paths(134,131,test179[0]);
        Paths pt345 = new Paths(135,131,test180[0]);
        Paths pt346 = new Paths(126,132,test173[0]);
        Paths pt347 = new Paths(130,132,test276[0]);
        Paths pt348 = new Paths(134,132,test181[0]);
        Paths pt349 = new Paths(130,133,test178[0]);
        Paths pt350 = new Paths(177,133,test277[0]);
        Paths pt351 = new Paths(131,134,test179[0]);
        Paths pt352 = new Paths(132,134,test181[0]);
        Paths pt353 = new Paths(135,134,test182[0]);//**
        Paths pt354 = new Paths(138,134,test183[0]);
        Paths pt355 = new Paths(131,135,test180[0]);
        Paths pt356 = new Paths(134,135,test182[0]);//**
        Paths pt357 = new Paths(137,136,test185[0]);
        Paths pt358 = new Paths(138,136,test184[0]);//**
        Paths pt359 = new Paths(48,137,test63[0]);
        Paths pt360 = new Paths(136,137,test185[0]);
        Paths pt361 = new Paths(138,137,test186[0]);
        Paths pt362 = new Paths(140,137,test187[0]);
        Paths pt363 = new Paths(134,138,test183[0]);
        Paths pt364 = new Paths(136,138,test184[0]);//**
        Paths pt365 = new Paths(137,138,test186[0]);
        Paths pt366 = new Paths(142,138,test188[0]);
        Paths pt367 = new Paths(54,139,test282[0]);
        Paths pt368 = new Paths(49,139,test64[0]);//**
        Paths pt369 = new Paths(48,139,test62[0]);
        Paths pt370 = new Paths(50,139,test70[0]);
        Paths pt371 = new Paths(137,140,test187[0]);
        Paths pt372 = new Paths(143,140,test189[0]);
        Paths pt373 = new Paths(144,140,test190[0]);//**
        Paths pt374 = new Paths(147,140,test191[0]);//**
        Paths pt375 = new Paths(46,141,test59[0]);
        Paths pt376 = new Paths(47,141,test61[0]);
        Paths pt377 = new Paths(144,141,test192[0]);
        Paths pt378 = new Paths(138,142,test188[0]);
        Paths pt379 = new Paths(149,142,test205[0]);
        Paths pt380 = new Paths(173,142,test193[0]);//**
        Paths pt381 = new Paths(175,142,test194[0]);
        Paths pt382 = new Paths(140,143,test189[0]);
        Paths pt383 = new Paths(145,143,test195[0]);
        Paths pt384 = new Paths(146,143,test196[0]);
        Paths pt385 = new Paths(140,144,test190[0]);//**
        Paths pt386 = new Paths(141,144,test192[0]);
        Paths pt387 = new Paths(145,144,test197[0]);
        Paths pt388 = new Paths(143,145,test195[0]);
        Paths pt389 = new Paths(144,145,test197[0]);
        Paths pt390 = new Paths(148,145,test198[0]);
        Paths pt391 = new Paths(143,146,test196[0]);
        Paths pt392 = new Paths(147,146,test199[0]);
        Paths pt393 = new Paths(148,146,test200[0]);//**
        Paths pt394 = new Paths(150,146,test207[0]);
        Paths pt395 = new Paths(140,147,test191[0]);//**
        Paths pt396 = new Paths(146,147,test199[0]);
        Paths pt397 = new Paths(149,147,test201[0]);
        Paths pt398 = new Paths(145,148,test198[0]);
        Paths pt399 = new Paths(146,148,test200[0]);//**
        Paths pt400 = new Paths(151,148,test202[0]);
        Paths pt401 = new Paths(153,148,test203[0]);
        Paths pt402 = new Paths(154,148,test204[0]);
        Paths pt403 = new Paths(142,149,test205[0]);
        Paths pt404 = new Paths(147,149,test201[0]);
        Paths pt405 = new Paths(150,149,test208[0]);
        Paths pt406 = new Paths(173,149,test206[0]);
        Paths pt407 = new Paths(146,150,test207[0]);
        Paths pt408 = new Paths(149,150,test208[0]);
        Paths pt409 = new Paths(151,150,test209[0]);
        Paths pt410 = new Paths(159,150,test210[0]);
        Paths pt411 = new Paths(167,150,test211[0]);
        Paths pt412 = new Paths(171,150,test212[0]);
        Paths pt413 = new Paths(172,150,test213[0]);
        Paths pt414 = new Paths(173,150,test214[0]);
        Paths pt415 = new Paths(148,151,test202[0]);
        Paths pt416 = new Paths(150,151,test209[0]);
        Paths pt417 = new Paths(152,151,test215[0]);//**
        Paths pt418 = new Paths(151,152,test215[0]);//**
        Paths pt419 = new Paths(153,152,test216[0]);
        Paths pt420 = new Paths(156,152,test217[0]);
        Paths pt421 = new Paths(158,152,test218[0]);
        Paths pt422 = new Paths(159,152,test226[0]);
        Paths pt423 = new Paths(148,153,test203[0]);
        Paths pt424 = new Paths(152,153,test216[0]);
        Paths pt425 = new Paths(155,153,test219[0]);//**
        Paths pt426 = new Paths(148,154,test204[0]);
        Paths pt427 = new Paths(155,154,test220[0]);
        Paths pt428 = new Paths(153,155,test219[0]);//**
        Paths pt429 = new Paths(154,155,test220[0]);
        Paths pt430 = new Paths(157,155,test221[0]);
        Paths pt431 = new Paths(152,156,test217[0]);
        Paths pt432 = new Paths(157,156,test222[0]);
        Paths pt433 = new Paths(155,157,test221[0]);
        Paths pt434 = new Paths(156,157,test222[0]);
        Paths pt435 = new Paths(160,157,test223[0]);
        Paths pt436 = new Paths(152,158,test218[0]);
        Paths pt437 = new Paths(160,158,test224[0]);
        Paths pt438 = new Paths(161,158,test225[0]);//**
        Paths pt439 = new Paths(150,159,test210[0]);
        Paths pt440 = new Paths(152,159,test226[0]);
        Paths pt441 = new Paths(162,159,test227[0]);//**
        Paths pt442 = new Paths(163,159,test228[0]);
        Paths pt443 = new Paths(157,160,test223[0]);
        Paths pt444 = new Paths(158,160,test224[0]);//**
        Paths pt445 = new Paths(165,160,test230[0]);
        Paths pt446 = new Paths(180,160,test229[0]);
        Paths pt447 = new Paths(158,161,test225[0]);
        Paths pt448 = new Paths(162,161,test231[0]);
        Paths pt449 = new Paths(165,161,test232[0]);
        Paths pt450 = new Paths(159,162,test227[0]);//**
        Paths pt451 = new Paths(161,162,test231[0]);
        Paths pt452 = new Paths(164,162,test233[0]);
        Paths pt453 = new Paths(159,163,test228[0]);
        Paths pt454 = new Paths(164,163,test234[0]);
        Paths pt455 = new Paths(167,163,test235[0]);
        Paths pt456 = new Paths(162,164,test233[0]);
        Paths pt457 = new Paths(163,164,test234[0]);
        Paths pt458 = new Paths(166,164,test236[0]);
        Paths pt459 = new Paths(160,165,test230[0]);
        Paths pt460 = new Paths(161,165,test232[0]);
        Paths pt461 = new Paths(166,165,test237[0]);
        Paths pt462 = new Paths(164,166,test236[0]);
        Paths pt463 = new Paths(165,166,test237[0]);
        Paths pt464 = new Paths(168,166,test238[0]);
        Paths pt465 = new Paths(150,167,test211[0]);
        Paths pt466 = new Paths(163,167,test235[0]);
        Paths pt467 = new Paths(169,167,test239[0]);
        Paths pt468 = new Paths(170,167,test240[0]);
        Paths pt469 = new Paths(166,168,test238[0]);
        Paths pt470 = new Paths(169,168,test241[0]);
        Paths pt471 = new Paths(179,168,test242[0]);
        Paths pt472 = new Paths(167,169,test239[0]);
        Paths pt473 = new Paths(168,169,test241[0]);
        Paths pt474 = new Paths(167,170,test240[0]);
        Paths pt475 = new Paths(171,170,test245[0]);
        Paths pt476 = new Paths(178,170,test246[0]);//**
        Paths pt477 = new Paths(150,171,test212[0]);
        Paths pt478 = new Paths(170,171,test245[0]);
        Paths pt479 = new Paths(172,171,test247[0]);
        Paths pt480 = new Paths(178,171,test248[0]);
        Paths pt481 = new Paths(150,172,test213[0]);
        Paths pt482 = new Paths(171,172,test247[0]);
        Paths pt483 = new Paths(173,172,test249[0]);
        Paths pt484 = new Paths(176,172,test251[0]);//**
        Paths pt485 = new Paths(195,172,test250[0]);//**
        Paths pt486 = new Paths(142,173,test193[0]);//**
        Paths pt487 = new Paths(149,173,test206[0]);
        Paths pt488 = new Paths(150,173,test214[0]);
        Paths pt489 = new Paths(172,173,test249[0]);
        Paths pt490 = new Paths(175,173,test252[0]);
        Paths pt491 = new Paths(175,174,test253[0]);
        Paths pt492 = new Paths(142,175,test194[0]);
        Paths pt493 = new Paths(173,175,test252[0]);
        Paths pt494 = new Paths(174,175,test253[0]);
        Paths pt495 = new Paths(176,175,test254[0]);
        Paths pt496 = new Paths(172,176,test251[0]);//**
        Paths pt497 = new Paths(175,176,test254[0]);
        Paths pt498 = new Paths(177,176,test278[0]);
        Paths pt499 = new Paths(129,177,test275[0]);
        Paths pt500 = new Paths(133,177,test277[0]);
        Paths pt501 = new Paths(176,177,test278[0]);
        Paths pt502 = new Paths(170,178,test249[0]);//**
        Paths pt503 = new Paths(171,178,test248[0]);
        Paths pt504 = new Paths(195,178,test255[0]);
        Paths pt505 = new Paths(168,179,test242[0]);
        Paths pt506 = new Paths(184,179,test244[0]);
        Paths pt507 = new Paths(189,179,test279[0]);
        Paths pt508 = new Paths(160,180,test229[0]);
        Paths pt509 = new Paths(181,180,test256[0]);
        Paths pt510 = new Paths(180,181,test256[0]);
        Paths pt511 = new Paths(182,181,test257[0]);
        Paths pt512 = new Paths(181,182,test257[0]);
        Paths pt513 = new Paths(183,182,test258[0]);
        Paths pt514 = new Paths(182,183,test258[0]);
        Paths pt515 = new Paths(40,183,test53[0]);
        Paths pt516 = new Paths(191,183,test259[0]);
        Paths pt517 = new Paths(179,184,test243[0]);
        Paths pt518 = new Paths(185,184,test260[0]);
        Paths pt519 = new Paths(189,184,test262[0]);
        Paths pt520 = new Paths(184,185,test260[0]);
        Paths pt521 = new Paths(186,185,test261[0]);
        Paths pt522 = new Paths(187,185,test263[0]);
        Paths pt523 = new Paths(188,185,test264[0]);
        Paths pt524 = new Paths(185,186,test261[0]);
        Paths pt525 = new Paths(185,187,test263[0]);
        Paths pt526 = new Paths(185,188,test264[0]);
        Paths pt527 = new Paths(197,188,test265[0]);
        Paths pt528 = new Paths(192,188,test266[0]);
        Paths pt529 = new Paths(179,189,test279[0]);
        Paths pt530 = new Paths(184,189,test262[0]);
        Paths pt531 = new Paths(195,190,test269[0]);
        Paths pt532 = new Paths(193,190,test270[0]);
        Paths pt533 = new Paths(183,191,test259[0]);
        Paths pt534 = new Paths(196,191,test271[0]);
        Paths pt535 = new Paths(197,191,test272[0]);
        Paths pt536 = new Paths(188,192,test266[0]);
        Paths pt537 = new Paths(193,192,test267[0]);
        Paths pt538 = new Paths(190,193,test270[0]);
        Paths pt539 = new Paths(192,193,test267[0]);
        Paths pt540 = new Paths(194,193,test268[0]);
        Paths pt541 = new Paths(193,194,test268[0]);
        Paths pt542 = new Paths(190,195,test269[0]);
        Paths pt543 = new Paths(178,195,test255[0]);
        Paths pt544 = new Paths(172,195,test250[0]);//**
        Paths pt545 = new Paths(191,196,test271[0]);
        Paths pt546 = new Paths(188,197,test265[0]);
        Paths pt547 = new Paths(191,197,test272[0]);
        Paths pt548 = new Paths(118,198,test163[0]);
        Paths pt549 = new Paths(117,198,test273[0]);
        Paths pt550 = new Paths(62,199,test85[0]);
        Paths pt551 = new Paths(61,199,test83[0]);
        Paths pt552 = new Paths(12,199,test15[0]);
        Paths pt553 = new Paths(58,199,test78[0]);
        Paths pt554 = new Paths(89,200,test123[0]);
        Paths pt555 = new Paths(93,200,test280[0]);
        Paths pt556 = new Paths(92,200,test281[0]);
        Paths pt557 = new Paths(91,200,test127[0]);
        Paths pt558 = new Paths(139,54,test282[0]);

        // IntersectionNode creates an object from the original navigation nodes to be added to the graph and be linked
        IntersectionNode node1 = new IntersectionNode(n1);
        IntersectionNode node2 = new IntersectionNode(n2);
        IntersectionNode node3 = new IntersectionNode(n3);
        IntersectionNode node4 = new IntersectionNode(n4);
        IntersectionNode node5 = new IntersectionNode(n5);
        IntersectionNode node6 = new IntersectionNode(n6);
        IntersectionNode node7 = new IntersectionNode(n7);
        IntersectionNode node8 = new IntersectionNode(n8);
        IntersectionNode node9 = new IntersectionNode(n9);
        IntersectionNode node10 = new IntersectionNode(n10);
        IntersectionNode node11 = new IntersectionNode(n11);
        IntersectionNode node12 = new IntersectionNode(n12);
        IntersectionNode node13 = new IntersectionNode(n13);
        IntersectionNode node14 = new IntersectionNode(n14);
        IntersectionNode node15 = new IntersectionNode(n15);
        IntersectionNode node16 = new IntersectionNode(n16);
        IntersectionNode node17 = new IntersectionNode(n17);
        IntersectionNode node18 = new IntersectionNode(n18);
        IntersectionNode node19 = new IntersectionNode(n19);
        IntersectionNode node20 = new IntersectionNode(n20);
        IntersectionNode node21 = new IntersectionNode(n21);
        IntersectionNode node22 = new IntersectionNode(n22);
        IntersectionNode node23 = new IntersectionNode(n23);
        IntersectionNode node24 = new IntersectionNode(n24);
        IntersectionNode node25 = new IntersectionNode(n25);
        IntersectionNode node26 = new IntersectionNode(n26);
        IntersectionNode node27 = new IntersectionNode(n27);
        IntersectionNode node28 = new IntersectionNode(n28);
        IntersectionNode node29 = new IntersectionNode(n29);
        IntersectionNode node30 = new IntersectionNode(n30);
        IntersectionNode node31 = new IntersectionNode(n31);
        IntersectionNode node32 = new IntersectionNode(n32);
        IntersectionNode node33 = new IntersectionNode(n33);
        IntersectionNode node34 = new IntersectionNode(n34);
        IntersectionNode node35 = new IntersectionNode(n35);
        IntersectionNode node36 = new IntersectionNode(n36);
        IntersectionNode node37 = new IntersectionNode(n37);
        IntersectionNode node38 = new IntersectionNode(n38);
        IntersectionNode node39 = new IntersectionNode(n39);
        IntersectionNode node40 = new IntersectionNode(n40);
        IntersectionNode node41 = new IntersectionNode(n41);
        IntersectionNode node42 = new IntersectionNode(n42);
        IntersectionNode node43 = new IntersectionNode(n43);
        IntersectionNode node44 = new IntersectionNode(n44);
        IntersectionNode node45 = new IntersectionNode(n45);
        IntersectionNode node46 = new IntersectionNode(n46);
        IntersectionNode node47 = new IntersectionNode(n47);
        IntersectionNode node48 = new IntersectionNode(n48);
        IntersectionNode node49 = new IntersectionNode(n49);
        IntersectionNode node50 = new IntersectionNode(n50);
        IntersectionNode node51 = new IntersectionNode(n51);
        IntersectionNode node52 = new IntersectionNode(n52);
        IntersectionNode node53 = new IntersectionNode(n53);
        IntersectionNode node54 = new IntersectionNode(n54);
        IntersectionNode node55 = new IntersectionNode(n55);
        IntersectionNode node56 = new IntersectionNode(n56);
        IntersectionNode node57 = new IntersectionNode(n57);
        IntersectionNode node58 = new IntersectionNode(n58);
        IntersectionNode node59 = new IntersectionNode(n59);
        IntersectionNode node60 = new IntersectionNode(n60);
        IntersectionNode node61 = new IntersectionNode(n61);
        IntersectionNode node62 = new IntersectionNode(n62);
        IntersectionNode node63 = new IntersectionNode(n63);
        IntersectionNode node64 = new IntersectionNode(n64);
        IntersectionNode node65 = new IntersectionNode(n65);
        IntersectionNode node66 = new IntersectionNode(n66);
        IntersectionNode node67 = new IntersectionNode(n67);
        IntersectionNode node68 = new IntersectionNode(n68);
        IntersectionNode node69 = new IntersectionNode(n69);
        IntersectionNode node70 = new IntersectionNode(n70);
        IntersectionNode node71 = new IntersectionNode(n71);
        IntersectionNode node72 = new IntersectionNode(n72);
        IntersectionNode node73 = new IntersectionNode(n73);
        IntersectionNode node74 = new IntersectionNode(n74);
        IntersectionNode node75 = new IntersectionNode(n75);
        IntersectionNode node76 = new IntersectionNode(n76);
        IntersectionNode node77 = new IntersectionNode(n77);
        IntersectionNode node78 = new IntersectionNode(n78);
        IntersectionNode node79 = new IntersectionNode(n79);
        IntersectionNode node80 = new IntersectionNode(n80);
        IntersectionNode node81 = new IntersectionNode(n81);
        IntersectionNode node82 = new IntersectionNode(n82);
        IntersectionNode node83 = new IntersectionNode(n83);
        IntersectionNode node84 = new IntersectionNode(n84);
        IntersectionNode node85 = new IntersectionNode(n85);
        IntersectionNode node86 = new IntersectionNode(n86);
        IntersectionNode node87 = new IntersectionNode(n87);
        IntersectionNode node88 = new IntersectionNode(n88);
        IntersectionNode node89 = new IntersectionNode(n89);
        IntersectionNode node90 = new IntersectionNode(n90);
        IntersectionNode node91 = new IntersectionNode(n91);
        IntersectionNode node92 = new IntersectionNode(n92);
        IntersectionNode node93 = new IntersectionNode(n93);
        IntersectionNode node94 = new IntersectionNode(n94);
        IntersectionNode node95 = new IntersectionNode(n95);
        IntersectionNode node96 = new IntersectionNode(n96);
        IntersectionNode node97 = new IntersectionNode(n97);
        IntersectionNode node98 = new IntersectionNode(n98);
        IntersectionNode node99 = new IntersectionNode(n99);
        IntersectionNode node100 = new IntersectionNode(n100);
        IntersectionNode node101 = new IntersectionNode(n101);
        IntersectionNode node102 = new IntersectionNode(n102);
        IntersectionNode node103 = new IntersectionNode(n103);
        IntersectionNode node104 = new IntersectionNode(n104);
        IntersectionNode node105 = new IntersectionNode(n105);
        IntersectionNode node106 = new IntersectionNode(n106);
        IntersectionNode node107 = new IntersectionNode(n107);
        IntersectionNode node108 = new IntersectionNode(n108);
        IntersectionNode node109 = new IntersectionNode(n109);
        IntersectionNode node110 = new IntersectionNode(n110);
        IntersectionNode node111 = new IntersectionNode(n111);
        IntersectionNode node112 = new IntersectionNode(n112);
        IntersectionNode node113 = new IntersectionNode(n113);
        IntersectionNode node114 = new IntersectionNode(n114);
        IntersectionNode node115 = new IntersectionNode(n115);
        IntersectionNode node116 = new IntersectionNode(n116);
        IntersectionNode node117 = new IntersectionNode(n117);
        IntersectionNode node118 = new IntersectionNode(n118);
        IntersectionNode node119 = new IntersectionNode(n119);
        IntersectionNode node120 = new IntersectionNode(n120);
        IntersectionNode node121 = new IntersectionNode(n121);
        IntersectionNode node122 = new IntersectionNode(n122);
        IntersectionNode node123 = new IntersectionNode(n123);
        IntersectionNode node124 = new IntersectionNode(n124);
        IntersectionNode node125 = new IntersectionNode(n125);
        IntersectionNode node126 = new IntersectionNode(n126);
        IntersectionNode node127 = new IntersectionNode(n127);
        IntersectionNode node128 = new IntersectionNode(n128);
        IntersectionNode node129 = new IntersectionNode(n129);
        IntersectionNode node130 = new IntersectionNode(n130);
        IntersectionNode node131 = new IntersectionNode(n131);
        IntersectionNode node132 = new IntersectionNode(n132);
        IntersectionNode node133 = new IntersectionNode(n133);
        IntersectionNode node134 = new IntersectionNode(n134);
        IntersectionNode node135 = new IntersectionNode(n135);
        IntersectionNode node136 = new IntersectionNode(n136);
        IntersectionNode node137 = new IntersectionNode(n137);
        IntersectionNode node138 = new IntersectionNode(n138);
        IntersectionNode node139 = new IntersectionNode(n139);
        IntersectionNode node140 = new IntersectionNode(n140);
        IntersectionNode node141 = new IntersectionNode(n141);
        IntersectionNode node142 = new IntersectionNode(n142);
        IntersectionNode node143 = new IntersectionNode(n143);
        IntersectionNode node144 = new IntersectionNode(n144);
        IntersectionNode node145 = new IntersectionNode(n145);
        IntersectionNode node146 = new IntersectionNode(n146);
        IntersectionNode node147 = new IntersectionNode(n147);
        IntersectionNode node148 = new IntersectionNode(n148);
        IntersectionNode node149 = new IntersectionNode(n149);
        IntersectionNode node150 = new IntersectionNode(n150);
        IntersectionNode node151 = new IntersectionNode(n151);
        IntersectionNode node152 = new IntersectionNode(n152);
        IntersectionNode node153 = new IntersectionNode(n153);
        IntersectionNode node154 = new IntersectionNode(n154);
        IntersectionNode node155 = new IntersectionNode(n155);
        IntersectionNode node156 = new IntersectionNode(n156);
        IntersectionNode node157 = new IntersectionNode(n157);
        IntersectionNode node158 = new IntersectionNode(n158);
        IntersectionNode node159 = new IntersectionNode(n159);
        IntersectionNode node160 = new IntersectionNode(n160);
        IntersectionNode node161 = new IntersectionNode(n161);
        IntersectionNode node162 = new IntersectionNode(n162);
        IntersectionNode node163 = new IntersectionNode(n163);
        IntersectionNode node164 = new IntersectionNode(n164);
        IntersectionNode node165 = new IntersectionNode(n165);
        IntersectionNode node166 = new IntersectionNode(n166);
        IntersectionNode node167 = new IntersectionNode(n167);
        IntersectionNode node168 = new IntersectionNode(n168);
        IntersectionNode node169 = new IntersectionNode(n169);
        IntersectionNode node170 = new IntersectionNode(n170);
        IntersectionNode node171 = new IntersectionNode(n171);
        IntersectionNode node172 = new IntersectionNode(n172);
        IntersectionNode node173 = new IntersectionNode(n173);
        IntersectionNode node174 = new IntersectionNode(n174);
        IntersectionNode node175 = new IntersectionNode(n175);
        IntersectionNode node176 = new IntersectionNode(n176);
        IntersectionNode node177 = new IntersectionNode(n177);
        IntersectionNode node178 = new IntersectionNode(n178);
        IntersectionNode node179 = new IntersectionNode(n179);
        IntersectionNode node180 = new IntersectionNode(n180);
        IntersectionNode node181 = new IntersectionNode(n181);
        IntersectionNode node182 = new IntersectionNode(n182);
        IntersectionNode node183 = new IntersectionNode(n183);
        IntersectionNode node184 = new IntersectionNode(n184);
        IntersectionNode node185 = new IntersectionNode(n185);
        IntersectionNode node186 = new IntersectionNode(n186);
        IntersectionNode node187 = new IntersectionNode(n187);
        IntersectionNode node188 = new IntersectionNode(n188);
        IntersectionNode node189 = new IntersectionNode(n189);
        IntersectionNode node190 = new IntersectionNode(n190);
        IntersectionNode node191 = new IntersectionNode(n191);
        IntersectionNode node192 = new IntersectionNode(n192);
        IntersectionNode node193 = new IntersectionNode(n193);
        IntersectionNode node194 = new IntersectionNode(n194);
        IntersectionNode node195 = new IntersectionNode(n195);
        IntersectionNode node196 = new IntersectionNode(n196);
        IntersectionNode node197 = new IntersectionNode(n197);
        IntersectionNode node198 = new IntersectionNode(n198);
        IntersectionNode node199 = new IntersectionNode(n199);
        IntersectionNode node200 = new IntersectionNode(n200);

        // creating an array of linked lists (hashed linked lists) so every array element (starting from 1) is a node in the graph
        // allows easy search of a node

        // inserts a node from the array element (and a path connecting it to something else) to the graph data structure
        // creates the graph

        IntersectionNode[] ina = new IntersectionNode[201];

        graph.insertPath(node1,pt1);
        graph.insertPath(node1,pt2);
        graph.insertPath(node2,pt3);
        graph.insertPath(node2,pt4);
        graph.insertPath(node3,pt5);
        graph.insertPath(node3,pt6);
        graph.insertPath(node4,pt7);
        graph.insertPath(node4,pt8);
        graph.insertPath(node5,pt9);
        graph.insertPath(node5,pt10);
        graph.insertPath(node5,pt11);
        graph.insertPath(node6,pt12);
        graph.insertPath(node7,pt13);
        graph.insertPath(node7,pt14);
        graph.insertPath(node8,pt15);
        graph.insertPath(node8,pt16);
        graph.insertPath(node9,pt17);
        graph.insertPath(node9,pt18);
        graph.insertPath(node10,pt19);
        graph.insertPath(node10,pt20);
        graph.insertPath(node11,pt21);
        graph.insertPath(node11,pt22);
        graph.insertPath(node12,pt23);
        graph.insertPath(node12,pt24);
        graph.insertPath(node12,pt25);
        graph.insertPath(node12,pt26);
        graph.insertPath(node12,pt27);
        graph.insertPath(node13,pt28);
        graph.insertPath(node13,pt28);
        graph.insertPath(node13,pt29);
        graph.insertPath(node14,pt30);
        graph.insertPath(node14,pt31);
        graph.insertPath(node14,pt32);
        graph.insertPath(node14,pt33);
        graph.insertPath(node15,pt34);
        graph.insertPath(node15,pt35);
        graph.insertPath(node15,pt36);
        graph.insertPath(node16,pt37);
        graph.insertPath(node16,pt38);
        graph.insertPath(node16,pt39);
        graph.insertPath(node17,pt40);
        graph.insertPath(node17,pt41);
        graph.insertPath(node17,pt42);
        graph.insertPath(node18,pt43);
        graph.insertPath(node18,pt44);
        graph.insertPath(node18,pt45);
        graph.insertPath(node19,pt46);
        graph.insertPath(node19,pt47);
        graph.insertPath(node19,pt48);
        graph.insertPath(node20,pt49);
        graph.insertPath(node20,pt50);
        graph.insertPath(node20,pt51);
        graph.insertPath(node21,pt52);
        graph.insertPath(node21,pt53);
        graph.insertPath(node21,pt54);
        graph.insertPath(node22,pt55);
        graph.insertPath(node23,pt56);
        graph.insertPath(node23,pt57);
        graph.insertPath(node24,pt58);
        graph.insertPath(node24,pt59);
        graph.insertPath(node25,pt60);
        graph.insertPath(node26,pt61);
        graph.insertPath(node26,pt62);
        graph.insertPath(node26,pt63);
        graph.insertPath(node27,pt64);
        graph.insertPath(node28,pt65);
        graph.insertPath(node28,pt66);
        graph.insertPath(node28,pt67);
        graph.insertPath(node29,pt68);
        graph.insertPath(node29,pt69);
        graph.insertPath(node30,pt70);
        graph.insertPath(node30,pt71);
        graph.insertPath(node30,pt72);//**
        graph.insertPath(node31,pt73);
        graph.insertPath(node31,pt74);
        graph.insertPath(node31,pt75);
        graph.insertPath(node32,pt76);
        graph.insertPath(node33,pt77);
        graph.insertPath(node33,pt78);
        graph.insertPath(node34,pt79);
        graph.insertPath(node34,pt80);
        graph.insertPath(node35,pt81);
        graph.insertPath(node35,pt82);
        graph.insertPath(node36,pt83);//**
        graph.insertPath(node36,pt84);
        graph.insertPath(node36,pt85);
        graph.insertPath(node36,pt86);//**
        graph.insertPath(node37,pt87);
        graph.insertPath(node37,pt88);
        graph.insertPath(node37,pt89);
        graph.insertPath(node38,pt90);
        graph.insertPath(node38,pt91);
        graph.insertPath(node38,pt92);//**
        graph.insertPath(node39,pt93);
        graph.insertPath(node39,pt94);
        graph.insertPath(node39,pt95);
        graph.insertPath(node40,pt96);//**
        graph.insertPath(node40,pt97);
        graph.insertPath(node40,pt98);
        graph.insertPath(node41,pt99);
        graph.insertPath(node41,pt100);
        graph.insertPath(node42,pt101);
        graph.insertPath(node42,pt102);
        graph.insertPath(node43,pt103);
        graph.insertPath(node43,pt104);
        graph.insertPath(node44,pt105);
        graph.insertPath(node44,pt106);
        graph.insertPath(node45,pt107);
        graph.insertPath(node45,pt108);
        graph.insertPath(node46,pt109);
        graph.insertPath(node46,pt110);//**
        graph.insertPath(node46,pt111);
        graph.insertPath(node47,pt112);//**
        graph.insertPath(node47,pt113);
        graph.insertPath(node47,pt114);
        graph.insertPath(node48,pt115);
        graph.insertPath(node48,pt116);
        graph.insertPath(node48,pt117);
        graph.insertPath(node48,pt118);
        graph.insertPath(node49,pt119);
        graph.insertPath(node49,pt120);//**
        graph.insertPath(node49,pt121);
        graph.insertPath(node49,pt122);
        graph.insertPath(node50,pt123);
        graph.insertPath(node50,pt124);
        graph.insertPath(node50,pt125);
        graph.insertPath(node50,pt126);
        graph.insertPath(node51,pt127);
        graph.insertPath(node51,pt128);
        graph.insertPath(node51,pt129);
        graph.insertPath(node52,pt130);
        graph.insertPath(node53,pt131);
        graph.insertPath(node54,pt132);
        graph.insertPath(node54,pt133);
        graph.insertPath(node54,pt134);//**
        graph.insertPath(node54,pt558);
        graph.insertPath(node55,pt135);
        graph.insertPath(node55,pt136);
        graph.insertPath(node56,pt137);
        graph.insertPath(node56,pt138);//**
        graph.insertPath(node56,pt139);
        graph.insertPath(node56,pt140);
        graph.insertPath(node57,pt141);
        graph.insertPath(node58,pt142);
        graph.insertPath(node58,pt143);
        graph.insertPath(node58,pt144);
        graph.insertPath(node58,pt145);
        graph.insertPath(node59,pt146);
        graph.insertPath(node59,pt147);
        graph.insertPath(node60,pt148);
        graph.insertPath(node60,pt149);
        graph.insertPath(node60,pt150);
        graph.insertPath(node61,pt151);
        graph.insertPath(node61,pt152);
        graph.insertPath(node61,pt153);
        graph.insertPath(node62,pt154);
        graph.insertPath(node62,pt155);
        graph.insertPath(node62,pt156);
        graph.insertPath(node63,pt157);
        graph.insertPath(node63,pt158);
        graph.insertPath(node63,pt159);
        graph.insertPath(node64,pt160);
        graph.insertPath(node64,pt161);
        graph.insertPath(node64,pt162);
        graph.insertPath(node64,pt163);
        graph.insertPath(node65,pt164);
        graph.insertPath(node65,pt165);
        graph.insertPath(node65,pt166);//**
        graph.insertPath(node66,pt167);
        graph.insertPath(node66,pt168);
        graph.insertPath(node66,pt169);
        graph.insertPath(node66,pt170);
        graph.insertPath(node67,pt171);
        graph.insertPath(node67,pt172);
        graph.insertPath(node67,pt173);
        graph.insertPath(node67,pt174);
        graph.insertPath(node68,pt175);
        graph.insertPath(node69,pt176);
        graph.insertPath(node69,pt177);
        graph.insertPath(node69,pt178);
        graph.insertPath(node70,pt179);
        graph.insertPath(node70,pt180);
        graph.insertPath(node70,pt181);//**
        graph.insertPath(node70,pt182);
        graph.insertPath(node71,pt183);//**
        graph.insertPath(node71,pt184);
        graph.insertPath(node72,pt185);
        graph.insertPath(node72,pt186);
        graph.insertPath(node72,pt187);
        graph.insertPath(node73,pt188);//**
        graph.insertPath(node73,pt189);
        graph.insertPath(node73,pt190);
        graph.insertPath(node74,pt191);
        graph.insertPath(node75,pt192);
        graph.insertPath(node75,pt193);
        graph.insertPath(node76,pt194);
        graph.insertPath(node76,pt195);
        graph.insertPath(node77,pt196);
        graph.insertPath(node77,pt197);
        graph.insertPath(node78,pt198);
        graph.insertPath(node78,pt199);
        graph.insertPath(node79,pt200);
        graph.insertPath(node79,pt201);
        graph.insertPath(node80,pt202);
        graph.insertPath(node80,pt203);
        graph.insertPath(node80,pt204);
        graph.insertPath(node81,pt205);
        graph.insertPath(node81,pt206);
        graph.insertPath(node81,pt207);
        graph.insertPath(node82,pt208);
        graph.insertPath(node82,pt209);
        graph.insertPath(node82,pt210);
        graph.insertPath(node82,pt211);
        graph.insertPath(node83,pt212);
        graph.insertPath(node83,pt213);
        graph.insertPath(node83,pt214);
        graph.insertPath(node84,pt215);
        graph.insertPath(node85,pt216);
        graph.insertPath(node85,pt217);
        graph.insertPath(node86,pt218);
        graph.insertPath(node86,pt219);
        graph.insertPath(node87,pt220);
        graph.insertPath(node87,pt221);
        graph.insertPath(node87,pt222);
        graph.insertPath(node88,pt223);
        graph.insertPath(node88,pt224);
        graph.insertPath(node89,pt225);
        graph.insertPath(node89,pt226);
        graph.insertPath(node89,pt227);
        graph.insertPath(node90,pt228);
        graph.insertPath(node90,pt229);
        graph.insertPath(node91,pt230);
        graph.insertPath(node91,pt231);
        graph.insertPath(node91,pt232);
        graph.insertPath(node92,pt233);
        graph.insertPath(node92,pt234);
        graph.insertPath(node92,pt235);
        graph.insertPath(node93,pt236);
        graph.insertPath(node93,pt237);
        graph.insertPath(node93,pt238);
        graph.insertPath(node94,pt239);
        graph.insertPath(node94,pt240);
        graph.insertPath(node94,pt241);
        graph.insertPath(node95,pt242);
        graph.insertPath(node95,pt243);
        graph.insertPath(node95,pt244);
        graph.insertPath(node96,pt245);
        graph.insertPath(node96,pt246);
        graph.insertPath(node97,pt247);
        graph.insertPath(node97,pt248);
        graph.insertPath(node97,pt249);
        graph.insertPath(node97,pt250);
        graph.insertPath(node98,pt251);
        graph.insertPath(node98,pt252);//**
        graph.insertPath(node99,pt253);
        graph.insertPath(node99,pt254);//**
        graph.insertPath(node99,pt255);
        graph.insertPath(node100,pt256);
        graph.insertPath(node100,pt257);
        graph.insertPath(node100,pt258);
        graph.insertPath(node101,pt259);
        graph.insertPath(node101,pt260);
        graph.insertPath(node102,pt261);
        graph.insertPath(node102,pt262);
        graph.insertPath(node103,pt263);
        graph.insertPath(node103,pt264);
        graph.insertPath(node103,pt265);
        graph.insertPath(node104,pt266);
        graph.insertPath(node104,pt267);
        graph.insertPath(node105,pt268);
        graph.insertPath(node105,pt269);
        graph.insertPath(node106,pt270);
        graph.insertPath(node107,pt271);
        graph.insertPath(node107,pt272);
        graph.insertPath(node108,pt273);
        graph.insertPath(node108,pt274);
        graph.insertPath(node108,pt275);
        graph.insertPath(node109,pt276);
        graph.insertPath(node109,pt277);
        graph.insertPath(node109,pt278);
        graph.insertPath(node110,pt279);
        graph.insertPath(node110,pt280);
        graph.insertPath(node111,pt281);
        graph.insertPath(node111,pt282);
        graph.insertPath(node112,pt283);
        graph.insertPath(node112,pt284);
        graph.insertPath(node112,pt285);
        graph.insertPath(node112,pt286);
        graph.insertPath(node113,pt287);
        graph.insertPath(node113,pt288);
        graph.insertPath(node113,pt289);
        graph.insertPath(node114,pt290);
        graph.insertPath(node114,pt291);
        graph.insertPath(node114,pt292);
        graph.insertPath(node115,pt293);
        graph.insertPath(node115,pt294);
        graph.insertPath(node115,pt295);
        graph.insertPath(node116,pt296);
        graph.insertPath(node116,pt297);
        graph.insertPath(node116,pt298);
        graph.insertPath(node116,pt299);
        graph.insertPath(node117,pt300);
        graph.insertPath(node117,pt301);
        graph.insertPath(node117,pt302);
        graph.insertPath(node117,pt303);
        graph.insertPath(node118,pt304);
        graph.insertPath(node118,pt305);
        graph.insertPath(node118,pt306);
        graph.insertPath(node119,pt307);
        graph.insertPath(node119,pt308);
        graph.insertPath(node119,pt309);
        graph.insertPath(node120,pt310);
        graph.insertPath(node120,pt311);
        graph.insertPath(node120,pt312);
        graph.insertPath(node121,pt313);
        graph.insertPath(node122,pt314);
        graph.insertPath(node123,pt315);
        graph.insertPath(node123,pt316);
        graph.insertPath(node123,pt317);
        graph.insertPath(node124,pt318);
        graph.insertPath(node124,pt319);
        graph.insertPath(node124,pt320);
        graph.insertPath(node125,pt321);
        graph.insertPath(node125,pt322);
        graph.insertPath(node126,pt323);
        graph.insertPath(node126,pt324);
        graph.insertPath(node126,pt325);//**
        graph.insertPath(node126,pt326);//**
        graph.insertPath(node126,pt327);
        graph.insertPath(node127,pt328);
        graph.insertPath(node127,pt329);
        graph.insertPath(node128,pt330);
        graph.insertPath(node128,pt331);
        graph.insertPath(node128,pt332);
        graph.insertPath(node129,pt333);
        graph.insertPath(node129,pt334);
        graph.insertPath(node129,pt335);//**
        graph.insertPath(node130,pt336);
        graph.insertPath(node130,pt337);//**
        graph.insertPath(node130,pt338);
        graph.insertPath(node130,pt339);//**
        graph.insertPath(node130,pt340);
        graph.insertPath(node130,pt341);
        graph.insertPath(node131,pt342);
        graph.insertPath(node131,pt343);//**
        graph.insertPath(node131,pt344);
        graph.insertPath(node131,pt345);
        graph.insertPath(node132,pt346);
        graph.insertPath(node132,pt347);
        graph.insertPath(node132,pt348);
        graph.insertPath(node133,pt349);
        graph.insertPath(node133,pt350);
        graph.insertPath(node134,pt351);
        graph.insertPath(node134,pt352);
        graph.insertPath(node134,pt353);//**
        graph.insertPath(node134,pt354);
        graph.insertPath(node135,pt355);
        graph.insertPath(node135,pt356);//**
        graph.insertPath(node136,pt357);
        graph.insertPath(node136,pt358);//**
        graph.insertPath(node137,pt359);
        graph.insertPath(node137,pt360);
        graph.insertPath(node137,pt361);
        graph.insertPath(node137,pt362);
        graph.insertPath(node138,pt363);
        graph.insertPath(node138,pt364);//**
        graph.insertPath(node138,pt365);
        graph.insertPath(node138,pt366);
        graph.insertPath(node139,pt367);
        graph.insertPath(node139,pt368);//**
        graph.insertPath(node139,pt369);
        graph.insertPath(node139,pt370);
        graph.insertPath(node140,pt371);
        graph.insertPath(node140,pt372);
        graph.insertPath(node140,pt373);//**
        graph.insertPath(node140,pt374);//**
        graph.insertPath(node141,pt375);
        graph.insertPath(node141,pt376);
        graph.insertPath(node141,pt377);
        graph.insertPath(node142,pt378);
        graph.insertPath(node142,pt379);
        graph.insertPath(node142,pt380);//**
        graph.insertPath(node142,pt381);
        graph.insertPath(node143,pt382);
        graph.insertPath(node143,pt383);
        graph.insertPath(node143,pt384);
        graph.insertPath(node144,pt385);//**
        graph.insertPath(node144,pt386);
        graph.insertPath(node144,pt387);
        graph.insertPath(node145,pt388);
        graph.insertPath(node145,pt389);
        graph.insertPath(node145,pt390);
        graph.insertPath(node146,pt391);
        graph.insertPath(node146,pt392);
        graph.insertPath(node146,pt393);//**
        graph.insertPath(node146,pt394);
        graph.insertPath(node147,pt395);//**
        graph.insertPath(node147,pt396);
        graph.insertPath(node147,pt397);
        graph.insertPath(node148,pt398);
        graph.insertPath(node148,pt399);//**
        graph.insertPath(node148,pt400);
        graph.insertPath(node148,pt401);
        graph.insertPath(node148,pt402);
        graph.insertPath(node149,pt403);
        graph.insertPath(node149,pt404);
        graph.insertPath(node149,pt405);
        graph.insertPath(node149,pt406);
        graph.insertPath(node150,pt407);
        graph.insertPath(node150,pt408);
        graph.insertPath(node150,pt409);
        graph.insertPath(node150,pt410);
        graph.insertPath(node150,pt411);
        graph.insertPath(node150,pt412);
        graph.insertPath(node150,pt413);
        graph.insertPath(node150,pt414);
        graph.insertPath(node151,pt415);
        graph.insertPath(node151,pt416);
        graph.insertPath(node151,pt417);//**
        graph.insertPath(node152,pt418);//**
        graph.insertPath(node152,pt419);
        graph.insertPath(node152,pt420);
        graph.insertPath(node152,pt421);
        graph.insertPath(node152,pt422);
        graph.insertPath(node153,pt423);
        graph.insertPath(node153,pt424);
        graph.insertPath(node153,pt425);//**
        graph.insertPath(node154,pt426);
        graph.insertPath(node154,pt427);
        graph.insertPath(node155,pt428);//**
        graph.insertPath(node155,pt429);
        graph.insertPath(node155,pt430);
        graph.insertPath(node156,pt431);
        graph.insertPath(node156,pt432);
        graph.insertPath(node157,pt433);
        graph.insertPath(node157,pt434);
        graph.insertPath(node157,pt435);
        graph.insertPath(node158,pt436);
        graph.insertPath(node158,pt437);
        graph.insertPath(node158,pt438);//**
        graph.insertPath(node159,pt439);
        graph.insertPath(node159,pt440);
        graph.insertPath(node159,pt441);//**
        graph.insertPath(node159,pt442);
        graph.insertPath(node160,pt443);
        graph.insertPath(node160,pt444);//**
        graph.insertPath(node160,pt445);
        graph.insertPath(node160,pt446);
        graph.insertPath(node161,pt447);
        graph.insertPath(node161,pt448);
        graph.insertPath(node161,pt449);
        graph.insertPath(node162,pt450);//**
        graph.insertPath(node162,pt451);
        graph.insertPath(node162,pt452);
        graph.insertPath(node163,pt453);
        graph.insertPath(node163,pt454);
        graph.insertPath(node163,pt455);
        graph.insertPath(node164,pt456);
        graph.insertPath(node164,pt457);
        graph.insertPath(node164,pt458);
        graph.insertPath(node165,pt459);
        graph.insertPath(node165,pt460);
        graph.insertPath(node165,pt461);
        graph.insertPath(node166,pt462);
        graph.insertPath(node166,pt463);
        graph.insertPath(node166,pt464);
        graph.insertPath(node167,pt465);
        graph.insertPath(node167,pt466);
        graph.insertPath(node167,pt467);
        graph.insertPath(node167,pt468);
        graph.insertPath(node168,pt469);
        graph.insertPath(node168,pt470);
        graph.insertPath(node168,pt471);
        graph.insertPath(node169,pt472);
        graph.insertPath(node169,pt473);
        graph.insertPath(node170,pt474);
        graph.insertPath(node170,pt475);
        graph.insertPath(node170,pt476);//**
        graph.insertPath(node171,pt477);
        graph.insertPath(node171,pt478);
        graph.insertPath(node171,pt479);
        graph.insertPath(node171,pt480);
        graph.insertPath(node172,pt481);
        graph.insertPath(node172,pt482);
        graph.insertPath(node172,pt483);
        graph.insertPath(node172,pt484);//**
        graph.insertPath(node172,pt485);//**
        graph.insertPath(node173,pt486);//**
        graph.insertPath(node173,pt487);
        graph.insertPath(node173,pt488);
        graph.insertPath(node173,pt489);
        graph.insertPath(node173,pt490);
        graph.insertPath(node174,pt491);
        graph.insertPath(node175,pt492);
        graph.insertPath(node175,pt493);
        graph.insertPath(node175,pt494);
        graph.insertPath(node175,pt495);
        graph.insertPath(node176,pt496);//**
        graph.insertPath(node176,pt497);
        graph.insertPath(node176,pt498);
        graph.insertPath(node177,pt499);
        graph.insertPath(node177,pt500);
        graph.insertPath(node177,pt501);
        graph.insertPath(node178,pt502);//**
        graph.insertPath(node178,pt503);
        graph.insertPath(node178,pt504);
        graph.insertPath(node179,pt505);
        graph.insertPath(node179,pt506);
        graph.insertPath(node179,pt507);
        graph.insertPath(node180,pt508);
        graph.insertPath(node180,pt509);
        graph.insertPath(node181,pt510);
        graph.insertPath(node181,pt511);
        graph.insertPath(node182,pt512);
        graph.insertPath(node182,pt513);
        graph.insertPath(node183,pt514);
        graph.insertPath(node183,pt515);
        graph.insertPath(node183,pt516);
        graph.insertPath(node184,pt517);
        graph.insertPath(node184,pt518);
        graph.insertPath(node184,pt519);
        graph.insertPath(node185,pt520);
        graph.insertPath(node185,pt521);
        graph.insertPath(node185,pt522);
        graph.insertPath(node185,pt523);
        graph.insertPath(node186,pt524);
        graph.insertPath(node187,pt525);
        graph.insertPath(node188,pt526);
        graph.insertPath(node188,pt527);
        graph.insertPath(node188,pt528);
        graph.insertPath(node189,pt529);
        graph.insertPath(node189,pt530);
        graph.insertPath(node190,pt531);
        graph.insertPath(node190,pt532);
        graph.insertPath(node191,pt533);
        graph.insertPath(node191,pt534);
        graph.insertPath(node191,pt535);
        graph.insertPath(node192,pt536);
        graph.insertPath(node192,pt537);
        graph.insertPath(node193,pt538);
        graph.insertPath(node193,pt539);
        graph.insertPath(node193,pt540);
        graph.insertPath(node194,pt541);
        graph.insertPath(node195,pt542);
        graph.insertPath(node195,pt543);
        graph.insertPath(node195,pt544);//**
        graph.insertPath(node196,pt545);
        graph.insertPath(node197,pt546);
        graph.insertPath(node197,pt547);
        graph.insertPath(node198,pt548);
        graph.insertPath(node198,pt549);
        graph.insertPath(node199,pt550);
        graph.insertPath(node199,pt551);
        graph.insertPath(node199,pt552);
        graph.insertPath(node199,pt553);
        graph.insertPath(node200,pt554);
        graph.insertPath(node200,pt555);
        graph.insertPath(node200,pt556);
        graph.insertPath(node200,pt557);


        ina[1]=node1;
        ina[2]=node2;
        ina[3]=node3;
        ina[4]=node4;
        ina[5]=node5;
        ina[6]=node6;
        ina[7]=node7;
        ina[8]=node8;
        ina[9]=node9;
        ina[10]=node10;
        ina[11]=node11;
        ina[12]=node12;
        ina[13]=node13;
        ina[14]=node14;
        ina[15]=node15;
        ina[16]=node16;
        ina[17]=node17;
        ina[18]=node18;
        ina[19]=node19;
        ina[20]=node20;
        ina[21]=node21;
        ina[22]=node22;
        ina[23]=node23;
        ina[24]=node24;
        ina[25]=node25;
        ina[26]=node26;
        ina[27]=node27;
        ina[28]=node28;
        ina[29]=node29;
        ina[30]=node30;
        ina[31]=node31;
        ina[32]=node32;
        ina[33]=node33;
        ina[34]=node34;
        ina[35]=node35;
        ina[36]=node36;
        ina[37]=node37;
        ina[38]=node38;
        ina[39]=node39;
        ina[40]=node40;
        ina[41]=node41;
        ina[42]=node42;
        ina[43]=node43;
        ina[44]=node44;
        ina[45]=node45;
        ina[46]=node46;
        ina[47]=node47;
        ina[48]=node48;
        ina[49]=node49;
        ina[50]=node50;
        ina[51]=node51;
        ina[52]=node52;
        ina[53]=node53;
        ina[54]=node54;
        ina[55]=node55;
        ina[56]=node56;
        ina[57]=node57;
        ina[58]=node58;
        ina[59]=node59;
        ina[60]=node60;
        ina[61]=node61;
        ina[62]=node62;
        ina[63]=node63;
        ina[64]=node64;
        ina[65]=node65;
        ina[66]=node66;
        ina[67]=node67;
        ina[68]=node68;
        ina[69]=node69;
        ina[70]=node70;
        ina[71]=node71;
        ina[72]=node72;
        ina[73]=node73;
        ina[74]=node74;
        ina[75]=node75;
        ina[76]=node76;
        ina[77]=node77;
        ina[78]=node78;
        ina[79]=node79;
        ina[80]=node80;
        ina[81]=node81;
        ina[82]=node82;
        ina[83]=node83;
        ina[84]=node84;
        ina[85]=node85;
        ina[86]=node86;
        ina[87]=node87;
        ina[88]=node88;
        ina[89]=node89;
        ina[90]=node90;
        ina[91]=node91;
        ina[92]=node92;
        ina[93]=node93;
        ina[94]=node94;
        ina[95]=node95;
        ina[96]=node96;
        ina[97]=node97;
        ina[98]=node98;
        ina[99]=node99;
        ina[100]=node100;
        ina[101]=node101;
        ina[102]=node102;
        ina[103]=node103;
        ina[104]=node104;
        ina[105]=node105;
        ina[106]=node106;
        ina[107]=node107;
        ina[108]=node108;
        ina[109]=node109;
        ina[110]=node110;
        ina[111]=node111;
        ina[112]=node112;
        ina[113]=node113;
        ina[114]=node114;
        ina[115]=node115;
        ina[116]=node116;
        ina[117]=node117;
        ina[118]=node118;
        ina[119]=node119;
        ina[120]=node120;
        ina[121]=node121;
        ina[122]=node122;
        ina[123]=node123;
        ina[124]=node124;
        ina[125]=node125;
        ina[126]=node126;
        ina[127]=node127;
        ina[128]=node128;
        ina[129]=node129;
        ina[130]=node130;
        ina[131]=node131;
        ina[132]=node132;
        ina[133]=node133;
        ina[134]=node134;
        ina[135]=node135;
        ina[136]=node136;
        ina[137]=node137;
        ina[138]=node138;
        ina[139]=node139;
        ina[140]=node140;
        ina[141]=node141;
        ina[142]=node142;
        ina[143]=node143;
        ina[144]=node144;
        ina[145]=node145;
        ina[146]=node146;
        ina[147]=node147;
        ina[148]=node148;
        ina[149]=node149;
        ina[150]=node150;
        ina[151]=node151;
        ina[152]=node152;
        ina[153]=node153;
        ina[154]=node154;
        ina[155]=node155;
        ina[156]=node156;
        ina[157]=node157;
        ina[158]=node158;
        ina[159]=node159;
        ina[160]=node160;
        ina[161]=node161;
        ina[162]=node162;
        ina[163]=node163;
        ina[164]=node164;
        ina[165]=node165;
        ina[166]=node166;
        ina[167]=node167;
        ina[168]=node168;
        ina[169]=node169;
        ina[170]=node170;
        ina[171]=node171;
        ina[172]=node172;
        ina[173]=node173;
        ina[174]=node174;
        ina[175]=node175;
        ina[176]=node176;
        ina[177]=node177;
        ina[178]=node178;
        ina[179]=node179;
        ina[180]=node180;
        ina[181]=node181;
        ina[182]=node182;
        ina[183]=node183;
        ina[184]=node184;
        ina[185]=node185;
        ina[186]=node186;
        ina[187]=node187;
        ina[188]=node188;
        ina[189]=node189;
        ina[190]=node190;
        ina[191]=node191;
        ina[192]=node192;
        ina[193]=node193;
        ina[194]=node194;
        ina[195]=node195;
        ina[196]=node196;
        ina[197]=node197;
        ina[198]=node198;
        ina[199]=node199;
        ina[200]=node200;

        int buildingCode=1;

        // uses data passed from OutdoorNav activity, which was user input for the buildings they wish to navigate to
        // it converts the input string to a buildingCode, which is the same as the array position of each respective node, so it knows where
        // to end the route calculation from the graph nodes/vertices.
        if(building.equals("ATH")){
            buildingCode = 15;
        }
        else if(building.equals("DHE")){
            buildingCode = 165;
        }
        else if(building.equals("EH")){
            buildingCode = 33;
        }
        else if(building.equals("GHC")){
            buildingCode = 99;
        }
        else if(building.equals("HAM")){
            buildingCode = 74;
        }
        else if(building.equals("HHS")){
            buildingCode = 178;
        }
        else if(building.equals("HHB")){
            buildingCode = 104;
        }
        else if(building.equals("KL")){
            buildingCode = 155;
        }
        else if(building.equals("NFH")){
            buildingCode = 121;
        }
        else if(building.equals("OC")){
            buildingCode = 136;
        }
        else if(building.equals("ODH")){
            buildingCode = 52;
        }
        else if(building.equals("PH")){
            buildingCode = 25;
        }
        else if(building.equals("REC")){
            buildingCode = 17;
        }
        else if(building.equals("SEB")){
            buildingCode = 186;
        }
        else if(building.equals("SFH")){
            buildingCode = 132;
        }
        else if(building.equals("VBH")){
            buildingCode = 68;
        }
        else if(building.equals("VAR")){
            buildingCode = 29;
        }
        else if(building.equals("WH")){
            buildingCode = 110;
        }

        // call to method to calculate the navigation route, passing the user input for end location and static start location
        Stack<IntersectionNode> outPath = DijkstraMod(ina,node150,findEndIndoor(ina,buildingCode));// static start node150 is the center of the library circle roundabout
        return(outPath);// stack returned after calculating the route, passed to OutdoorNav class to display
    }


    // not used at the end
    /*public static boolean doesBacktrack(PathNode pn, IntersectionNode pre)
    {
        if(pn.getNext().getPath().getIdI()==pre.getIntersect().getId()) {
            return true;
        }
        return false;
    }*/

    // method to find the start node for outdoor navigation, if user location has to be recorded and used to find the closest
    // graph node to start from
    // not implemented, static start node used (node n150 - center of library circle roundabout)
    public static IntersectionNode findStartNode(Location now, IntersectionNode[] ina, double range)
    {
        for(int i=0;i<ina.length;i++)
        {
            if((Math.abs(ina[i].getIntersect().getLat()-now.getLatitude())<=range) && (Math.abs(ina[i].getIntersect().getLon()-now.getLongitude())<=range))
            {
                    return ina[i];
            }
        }
        return findStartNode(now,ina,range*2);
    }

    // method for finding the start node for indoor navigation, called inside initializeIndoor and
    // it takes into account input location from user (current user location) and the array of linked lists to find the corresponding node
    public static IntersectionNode findStartIndoor(IntersectionNode[] ina, int roomCode)
    {
        IntersectionNode startIndoor = new IntersectionNode();

        for(int i=0;i<ina.length;i++){
            if(ina[roomCode]==ina[i]){
                startIndoor = ina[i];
                break;
            }
        }
        return startIndoor;
    }

    // method for finding the destination node for indoor navigation, called inside initializeIndoor and
    // it takes into account input location from user (desired room destination) and the array of linked lists to find the corresponding node
    public static IntersectionNode findEndIndoor(IntersectionNode[] ina, int roomCode)
    {
        IntersectionNode endIndoor = new IntersectionNode();

        for(int i=0;i<ina.length;i++){
            if(ina[roomCode]==ina[i]){
                endIndoor = ina[i];
                break;
            }
        }
        return endIndoor;
    }

    // method implemented to check that the next graph node to add to the path route is not only the closest to the previous node,
    // but also the one that gets "closer" to the destination node as well
    public static boolean getsCloser(IntersectionNode curr, IntersectionNode next, IntersectionNode Final)
    {
        //use distanceBetween method
        //if distance between is greater than last node, don't use it
        float[] results1=new float[3];
        float[] results2=new float[3];
        distanceBetween(next.getIntersect().getLat(), next.getIntersect().getLon(), Final.getIntersect().getLat(), Final.getIntersect().getLon(), results1);
        distanceBetween(curr.getIntersect().getLat(), curr.getIntersect().getLon(), Final.getIntersect().getLat(), Final.getIntersect().getLon(), results2);
        if(results1[0]<results2[0])
        {
            return true;
        }
            return false;
    }

    //ALGORITHM FOR FINDING THE SHORTEST PATH - or building up the route to navigate, based on graph input and start and destination nodes
    // based on Dijkstra's algorithm, but developed to accommodate undirected edges as well as getting the nodes that are the closest
    // instead of just being the shortest ones from the current graph node
    // also developed to accommodate the hashed linked list graph representation used
    public static Stack<IntersectionNode> DijkstraMod(IntersectionNode[] ina, IntersectionNode startNode, IntersectionNode FinalNode)
    {
        //Stacks to keep track of nodes in path, and children of that path
        Stack<IntersectionNode> path = new Stack<IntersectionNode>();
        Stack<PathNode> children=new Stack<PathNode>();
        //Distance Accummulator
        double bestDist=0;
        int stackCount=1, childCount=0;;
        //mark start node as visited
        startNode.setVisited(true);
        //Keep track of previous node so we don't backtrack
        IntersectionNode predecessor = startNode,currNode=startNode,search=ina[1];
        //Keep track of path
        PathNode currPath = null, bestNode=null;
        //push start node into the path
        path.push(startNode);

        // IF CANNOT FIND SOURCE OR DESTINATION
        if(startNode == null || FinalNode == null)
        {
            return null;
        }

        //check to see if we are at the end of the graph
        while(currNode!=FinalNode)
        {
            currPath=currNode.getNextP();
            //check to see if we have not examined all of the paths coming from the node (examines the linked list connected to each array element
            while(currPath!=null)
            {
                //check to see if the next node from a path makes us backtrack
                if((!ina[currPath.getPath().getIdP()].isVisited()) )
                {
                    // if not visited, then add this node to path list to check for best distance
                    children.push(currPath);
                    //Look at next one
                    currPath = currPath.getNext();
                }
                else
                {
                    //Look at next one
                    currPath = currPath.getNext();
                }
            }

            Stack<PathNode> close = new Stack<PathNode>();// used to filter down all possible "shortest" nodes to jump to and only picks the ones
            childCount=0;
            // that get us closer to the destination node
            while(!children.isEmpty())
            {
                if(getsCloser(currNode,ina[children.peek().getPath().getIdP()],FinalNode))
                {
                    childCount++;
                    close.push(children.pop());
                }
                /*else if(children.size()==1) // if it doesn't get closer but it's the only connected node, then add it anyways
                {
                    close.push(children.pop());
                }*/
                else // gets rid of all the nodes that don't get us closer to the destination
                {
                    children.pop();
                }
            }

            if(!close.isEmpty()) // once we have the useful nodes, we pick the closest one from the previous node in the path
            {
                //put first one as best temporarily
                bestNode=close.pop();
                bestDist=bestNode.getPath().getDistance();
            }
            else
            {
                path.pop();
                totalDist-=bestDist;
                currNode=predecessor;
                continue;
            }

            while(!close.isEmpty())//check every element for picking the best node (closest and more direct to the destination)
            {
                PathNode child = close.pop();
                if((bestNode.getPath().getDistance()>child.getPath().getDistance()))//if find best, replace
                {
                    bestNode=child;
                    bestDist=child.getPath().getDistance();
                }
            }

            int id=bestNode.getPath().getIdP();
            predecessor=currNode;
            predecessor.setVisited(true);// set previous node to predecessor so it doesn't get visited anymore
            //checks array for next node to pick from the graph to continue building up the path
            for(int i=1;i<ina.length;i++)
            {
                search=ina[i];
                if(search.getIntersect().getId()==id)
                {
                    currNode=search;
                    break;
                }
            }
            //add best to total and path
            totalDist+=bestDist; // accummulates distance
            path.push(currNode);
            stackCount++;
        }

        return path; // stack containing the route to be returned and sent to be displayed
    }// end algorithm

} // ends class

