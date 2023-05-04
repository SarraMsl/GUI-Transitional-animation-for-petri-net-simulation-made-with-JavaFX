package com.example.demo15;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;
public class Controller implements Initializable {
    @FXML
    private Label p31,p32,p33,p41,p42,p43,p51,p52,p53,p00,p11,p12,p13,p21,p22,p23;

    @FXML
    private Line t42,t32,t33,t35,t43,t51,t12,t13,t14,t22;
    @FXML
    Polyline t41, t31,t34,t44,t52,t11,t23,t21,t15;
    @FXML
    AnchorPane pane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Place[] places = new Place[16];
        Transition[] transitions = new Transition[12];
        Semaphore s = new Semaphore(1);


        places[0] = new Place(1,
                "sec.libre1",
                1,
                new int[]{},
                new int[]{1},
                1);


        places[1] = new Place(2,
                "sec.libre2",
                1,
                new int[]{},
                new int[]{2}
                , 1);


        places[2] = new Place(3,
                "sec.libre3",
                1,
                new int[]{},
                new int[]{3}
                , 3);


        places[3] = new Place(4,
                "sec.libre4",
                1,
                new int[]{},
                new int[]{4}
                , 4);


        places[4] = new Place(5,
                "sec.libre5",
                1,
                new int[]{},
                new int[]{5}
                , 5);

        places[5] = new Place(6,
                "Eespace",
                1,
                new int[]{4, 2},
                new int[]{6}
                , 6);

        places[6] = new Place(7,
                "Mvt1",
                0,
                new int[]{1},
                new int[]{7}
                , 1);
        places[7] = new Place(8,
                "Mvt2",
                0,
                new int[]{2},
                new int[]{8}
                , 2);

        places[8] = new Place(9,
                "Mvt3",
                0,
                new int[]{3},
                new int[]{9}
                , 3);

        places[9] = new Place(10,
                "Mvt4",
                0,
                new int[]{4},
                new int[]{10}
                , 4);
        places[10] = new Place(11,
                "Mvt5",
                0,
                new int[]{5},
                new int[]{11}
                , 5);

        places[11] = new Place(12,
                "porte1",
                0,
                new int[]{7},
                new int[]{12}
                , 5);

        places[12] = new Place(13,
                "porte2",
                0,
                new int[]{8},
                new int[]{13}
                , 5);

        places[13] = new Place(14,
                "porte3",
                0,
                new int[]{9},
                new int[]{14}
                , 5);

        places[14] = new Place(15,
                "porte4",
                0,
                new int[]{10},
                new int[]{15}
                , 5);

        places[15] = new Place(16,
                "porte5",
                0,
                new int[]{11},
                new int[]{16}
                , 5);

        transitions[0] = new Transition(1,
                "Arrive chariot ",
                new int[]{1},
                new int[]{7});

        transitions[1] = new Transition(2,
                "Arrive chariot ",
                new int[]{2, 6, 12},
                new int[]{1, 1, 8});

        transitions[2] = new Transition(3,
                "Arrive chariot ",
                new int[]{3},
                new int[]{9});

        transitions[3] = new Transition(4,
                "Arrive chariot ",
                new int[]{4},
                new int[]{3});

        transitions[4] = new Transition(5,
                "Arrive chariot ",
                new int[]{5},
                new int[]{4});

        transitions[5] = new Transition(6,
                "Arrive chariot ",
                new int[]{7},
                new int[]{12});

        transitions[6] = new Transition(7,
                "Arrive chariot ",
                new int[]{8, 8},
                new int[]{13, 6});

        transitions[7] = new Transition(8,
                "Arrive chariot ",
                new int[]{10, 10},
                new int[]{15, 6});

        transitions[8] = new Transition(9,
                "Arrive chariot ",
                new int[]{11},
                new int[]{16});
//------------------------------------------------
        transitions[9] = new Transition(10,
                "Arrive chariot ",
                new int[]{9},
                new int[]{14});

        transitions[10] = new Transition(11,
                "Arrive chariot ",
                new int[]{16},
                new int[]{5});

        transitions[11] = new Transition(12,
                "Arrive chariot ",
                new int[]{13},
                new int[]{2});
        while (true) {

            for (int i = 0; i < places.length; i++)
                places[i].activate(1);
            for (int i = 0; i < places.length; i++)
                places[i].activate(2);
            for (int i = 0; i < places.length; i++)
                places[i].activate(3);

            for (int i = 0; i < places.length; i++)
                places[i].activate(4);
            for (int i = 0; i < places.length; i++)
                places[i].activate(5);
            for (int i = 0; i < places.length; i++)
                places[i].activate(6);


            transitions[0].activate();

            transitions[1].activate();

            transitions[2].activate();


            transitions[3].activate();

            transitions[4].activate();


            (new Thread(() -> {

                if (places[0].jetons > 0) {

                    System.out.println(places[0].jetons + " chario dans sec 1 ");
                    System.out.println(places[6].jetons + " chario dans Mvt1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });
                    transitions[0].activate();


                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[2].jetons > 0) {

                    System.out.println(places[2].jetons + " chario dans sec3");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t31);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p32, 1);

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3");
                    System.out.println(--places[2].jetons + " chario dans sec3");


                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[3].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });


                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p31, 1);
                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    System.out.println(--places[3].jetons + " chario dans sec4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[4].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p41, 1);

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    System.out.println(++places[3].jetons + " chario dans sec4");


                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons > 0 && (places[0].jetons == 0 || places[2].jetons == 0)) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[0].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[0].jetons + " chario dans sec1");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[1].activate();

                        Controller.this.addValue(Controller.this.p11, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[0].jetons + " chario dans sec1");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }


            })).run();


            (new Thread(() -> {

                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });
                    transitions[5].activate();


                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[3].jetons > 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(--places[3].jetons + " chario dans sec4 ");
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[5].jetons > 0 && (places[0].jetons == 0 || places[2].jetons == 0)) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[0].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[0].jetons + " chario dans sec1");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[1].activate();

                        Controller.this.addValue(Controller.this.p11, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[0].jetons + " chario dans sec1");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }

            })).run();
            (new Thread(() -> {
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });
                    transitions[9].activate();


                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


            })).run();


            (new Thread(() -> {
                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    } else if (places[5].jetons != 0) {

                        if (places[12].jetons == 0) {
                            System.out.println(places[7].jetons + " chario dans Mvt2");
                            System.out.println(places[12].jetons + " chario dans porte 2");
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                                }
                            });
                            transitions[6].activate();

                            Controller.this.addValue(Controller.this.p22, 1);
                            Controller.this.addValue(Controller.this.p23, -1);

                            System.out.println(--places[7].jetons + " chario dans Mvt2");
                            System.out.println(++places[12].jetons + " chario dans porte 2");
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException var7) {
                                var7.printStackTrace();
                            }
                        }
                    }
                }


                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[6].jetons > 0) {

                    System.out.println(places[11].jetons + " chario dans Mvt1 ");
                    System.out.println(places[6].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[14].jetons + " chario dans porte4");
                        Controller.this.addValue(Controller.this.p43, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                            }
                        });

                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);

                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[14].jetons + " chario dans porte4");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                } else if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });
                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[5].jetons > 0) {

                    System.out.println(places[2].jetons + " chario dans sec3 ");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p00, -1);
                    System.out.println(--places[5].jetons + " chario dans Espace");

                    System.out.println(++places[2].jetons + " chario dans sec3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    } else if (places[5].jetons != 0) {

                        if (places[12].jetons == 0) {
                            System.out.println(places[7].jetons + " chario dans Mvt2");
                            System.out.println(places[12].jetons + " chario dans porte 2");
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                                }
                            });
                            transitions[6].activate();

                            Controller.this.addValue(Controller.this.p22, 1);
                            Controller.this.addValue(Controller.this.p23, -1);

                            System.out.println(--places[7].jetons + " chario dans Mvt2");
                            System.out.println(++places[12].jetons + " chario dans porte 2");
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException var7) {
                                var7.printStackTrace();
                            }
                        }
                    }
                }


                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });
                    transitions[4].activate();


                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[14].jetons + " chario dans porte4");
                        Controller.this.addValue(Controller.this.p43, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                            }
                        });


                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[14].jetons + " chario dans porte4");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                } else if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });

                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();


            (new Thread(() -> {
                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {

                    System.out.println(places[2].jetons + " chario dans sec3 ");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p00, -1);
                    System.out.println(--places[5].jetons + " chario dans Espace");

                    System.out.println(++places[2].jetons + " chario dans sec3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    } else if (places[5].jetons != 0) {

                        if (places[12].jetons == 0) {
                            System.out.println(places[7].jetons + " chario dans Mvt2");
                            System.out.println(places[12].jetons + " chario dans porte 2");
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                                }
                            });
                            transitions[6].activate();

                            Controller.this.addValue(Controller.this.p22, 1);
                            Controller.this.addValue(Controller.this.p23, -1);

                            System.out.println(--places[7].jetons + " chario dans Mvt2");
                            System.out.println(++places[12].jetons + " chario dans porte 2");
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException var7) {
                                var7.printStackTrace();
                            }
                        }
                    }
                }


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });
                    transitions[4].activate();


                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[14].jetons + " chario dans porte4");
                        Controller.this.addValue(Controller.this.p43, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                            }
                        });


                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[14].jetons + " chario dans porte4");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                } else if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });
                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }


            })).run();


            (new Thread(() -> {
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }


                    if (places[2].jetons == 0) {
                        if (places[5].jetons > 0) {

                            System.out.println(places[2].jetons + " chario dans sec3 ");
                            System.out.println(places[5].jetons + " chario dans Espace");
                            Controller.this.addValue(Controller.this.p31, 1);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                                }
                            });

                            transitions[3].activate();

                            Controller.this.addValue(Controller.this.p00, -1);
                            System.out.println(--places[5].jetons + " chario dans Espace");

                            System.out.println(++places[2].jetons + " chario dans sec3 ");
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException var7) {
                                var7.printStackTrace();
                            }
                        }
                    }

                    //////////////////////////////////
                    if (places[15].jetons > 0) {

                        System.out.println(places[4].jetons + " chario dans sec5 ");
                        System.out.println(places[15].jetons + " chario dans porte 5");
                        Controller.this.addValue(Controller.this.p51, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                            }
                        });

                        transitions[8].activate();

                        Controller.this.addValue(Controller.this.p53, -1);
                        System.out.println(--places[15].jetons + " chario dans porte 5");

                        System.out.println(++places[4].jetons + " chario dans sec5");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }


                    if (places[10].jetons > 0) {
                        System.out.println(places[10].jetons + " chario dans Mvt5");
                        System.out.println(places[15].jetons + " chario dans porte 5");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                            }
                        });
                        transitions[8].activate();

                        Controller.this.addValue(Controller.this.p53, 1);
                        Controller.this.addValue(Controller.this.p52, -1);

                        System.out.println(--places[10].jetons + " chario dans Mvt5");
                        System.out.println(++places[15].jetons + " chario dans porte 5");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                    if (places[14].jetons > 0) {

                        System.out.println(places[10].jetons + " chario dans Mvt5 ");
                        System.out.println(places[14].jetons + "chario dans porte 4");
                        Controller.this.addValue(Controller.this.p52, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                            }
                        });
                        transitions[4].activate();


                        Controller.this.addValue(Controller.this.p43, -1);
                        System.out.println(++places[10].jetons + " chario dans Mvt5");
                        System.out.println(--places[14].jetons + "chario dans porte 4");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }


                    if (places[13].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4  ");
                        System.out.println(places[13].jetons + " chario dans porte3");
                        Controller.this.addValue(Controller.this.p42, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                            }
                        });
                        transitions[3].activate();


                        Controller.this.addValue(Controller.this.p33, -1);
                        System.out.println(--places[13].jetons + " chario dans porte3");
                        System.out.println(++places[9].jetons + " chario dans Mvt4");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[8].jetons > 0) {

                        System.out.println(places[13].jetons + " chario dans porte3 ");
                        System.out.println(places[8].jetons + " chario dans Mvt3");
                        Controller.this.addValue(Controller.this.p33, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                            }
                        });

                        transitions[9].activate();

                        Controller.this.addValue(Controller.this.p32, -1);
                        System.out.println(--places[8].jetons + " chario dans Mvt3");

                        System.out.println(++places[13].jetons + " chario dans porte3 ");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[2].jetons > 0) {

                        System.out.println(places[8].jetons + " chario dans Mvt3");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Controller.this.addValue(Controller.this.p32, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                            }
                        });


                        transitions[2].activate();

                        Controller.this.addValue(Controller.this.p31, -1);
                        System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                        System.out.println(--places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }


                }
            })).run();

//////////////////////////////////////////////////////////////////////////////////////////////////
            (new Thread(() -> {


                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });


                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });

                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });

                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {


                if (places[3].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });


                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p31, 1);
                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    System.out.println(--places[3].jetons + " chario dans sec4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });


                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });

                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });
                    transitions[4].activate();


                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });


                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });
                    transitions[4].activate();


                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[3].jetons > 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(--places[3].jetons + " chario dans sec4 ");
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();
            (new Thread(() -> {
                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });
                    transitions[8].activate();


                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });
                    transitions[9].activate();


                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[3].jetons > 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(--places[3].jetons + " chario dans sec4 ");
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();
            (new Thread(() -> {
                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });
                    transitions[10].activate();


                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[3].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });


                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p31, 1);
                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    System.out.println(--places[3].jetons + " chario dans sec4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });

                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p00, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[5].jetons + " chario dans Espace");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[3].jetons > 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(--places[3].jetons + " chario dans sec4 ");
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[5].jetons > 0 && (places[0].jetons == 0 || places[2].jetons == 0)) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[0].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[0].jetons + " chario dans sec1");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[1].activate();

                        Controller.this.addValue(Controller.this.p11, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[0].jetons + " chario dans sec1");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }

                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p00, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[5].jetons + " chario dans Espace");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();


            (new Thread(() -> {


                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[3].jetons > 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(--places[3].jetons + " chario dans sec4 ");
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[5].jetons > 0 && (places[0].jetons == 0 || places[2].jetons == 0)) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }

                    if (places[0].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[0].jetons + " chario dans sec1");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[1].activate();

                        Controller.this.addValue(Controller.this.p11, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[0].jetons + " chario dans sec1");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }


                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p00, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[5].jetons + " chario dans Espace");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


            })).run();


            (new Thread(() -> {

                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });
                    transitions[9].activate();


                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[0].jetons == 0) {
                    System.out.println(places[5].jetons + " chario dans Escpace");
                    System.out.println(places[0].jetons + " chario dans sec1");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);
                    Controller.this.addValue(Controller.this.p00, -1);

                    System.out.println(--places[5].jetons + " chario dans Escpace");
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


            })).run();


            (new Thread(() -> {

                if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });
                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }

                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();


            (new Thread(() -> {

                if (places[0].jetons == 0) {
                    System.out.println(places[5].jetons + " chario dans Escpace");
                    System.out.println(places[0].jetons + " chario dans sec1");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);
                    Controller.this.addValue(Controller.this.p00, -1);

                    System.out.println(--places[5].jetons + " chario dans Escpace");
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });

                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons != 0) {

                    if (places[12].jetons == 0) {
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        System.out.println(places[12].jetons + " chario dans porte 2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p22, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        System.out.println(++places[12].jetons + " chario dans porte 2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();

            (new Thread(() -> {
                if (places[0].jetons > 0) {

                    System.out.println(places[0].jetons + " chario dans sec 1 ");
                    System.out.println(places[6].jetons + " chario dans Mvt1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons == 0) {
                    System.out.println(places[5].jetons + " chario dans Escpace");
                    System.out.println(places[0].jetons + " chario dans sec1");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);
                    Controller.this.addValue(Controller.this.p00, -1);

                    System.out.println(--places[5].jetons + " chario dans Escpace");
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });
                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec 2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {


                if (places[5].jetons > 0) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }

                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();


                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });
                    transitions[0].activate();


                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });
                    transitions[0].activate();


                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec 2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[11].jetons + " chario dans Mvt1 ");
                    System.out.println(places[6].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });
                    transitions[5].activate();


                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });
                    transitions[0].activate();


                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();

            (new Thread(() -> {
                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });


                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec 2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });
                    transitions[1].activate();


                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });
                    transitions[5].activate();


                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();

            (new Thread(() -> {

                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0 && (places[0].jetons == 0 || places[2].jetons == 0)) {
                    if (places[2].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[2].jetons + " chario dans sec3");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                            }
                        });
                        transitions[3].activate();

                        Controller.this.addValue(Controller.this.p31, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[2].jetons + " chario dans sec3");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });
                    transitions[1].activate();


                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {
                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[11].jetons + " chario dans Mvt1 ");
                    System.out.println(places[6].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {

                    System.out.println(places[2].jetons + " chario dans sec3 ");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p00, -1);
                    System.out.println(--places[5].jetons + " chario dans Espace");

                    System.out.println(++places[2].jetons + " chario dans sec3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }

            })).run();

            (new Thread(() -> {

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });
                    transitions[10].activate();


                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });
                    transitions[6].activate();


                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[11].jetons + " chario dans Mvt1 ");
                    System.out.println(places[6].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });
                    transitions[5].activate();


                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {

                    System.out.println(places[2].jetons + " chario dans sec3 ");
                    System.out.println(places[5].jetons + " chario dans Espace");
                    Controller.this.addValue(Controller.this.p31, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t35);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p00, -1);
                    System.out.println(--places[5].jetons + " chario dans Espace");

                    System.out.println(++places[2].jetons + " chario dans sec3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


            })).run();


            (new Thread(() -> {

                if (places[4].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p41, 1);

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    System.out.println(++places[3].jetons + " chario dans sec4");


                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });

                    transitions[9].activate();

                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[3].jetons > 0) {
                    System.out.println(places[2].jetons + " chario dans sec4");
                    System.out.println(places[3].jetons + " chario dans sec3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p31, 1);
                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    System.out.println(--places[3].jetons + " chario dans sec4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec 2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();
                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons == 0) {
                    System.out.println(places[7].jetons + " chario dans Mvt2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p22, 1);
                    Controller.this.addValue(Controller.this.p23, -1);

                    System.out.println(--places[7].jetons + " chario dans Mvt2");
                    System.out.println(++places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });
                    transitions[9].activate();


                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


            })).run();


            (new Thread(() -> {


                if (places[2].jetons > 0) {

                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Controller.this.addValue(Controller.this.p32, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });
                    transitions[2].activate();

                    Controller.this.addValue(Controller.this.p31, -1);
                    System.out.println(++places[8].jetons + " chario dans Mvt3 ");
                    System.out.println(--places[2].jetons + " chario dans sec3");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[11].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }

                }


                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });
                    transitions[3].activate();


                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();


            (new Thread(() -> {


                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });
                    transitions[4].activate();


                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[9].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4");
                    System.out.println(places[14].jetons + " chario dans porte4");
                    Controller.this.addValue(Controller.this.p43, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t42);
                        }
                    });
                    transitions[7].activate();

                    Controller.this.addValue(Controller.this.p42, -1);
                    System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                    System.out.println(++places[14].jetons + " chario dans porte4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[8].jetons > 0) {

                    System.out.println(places[13].jetons + " chario dans porte3 ");
                    System.out.println(places[8].jetons + " chario dans Mvt3");
                    Controller.this.addValue(Controller.this.p33, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t32);
                        }
                    });
                    transitions[9].activate();


                    Controller.this.addValue(Controller.this.p32, -1);
                    System.out.println(--places[8].jetons + " chario dans Mvt3");

                    System.out.println(++places[13].jetons + " chario dans porte3 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[1].jetons > 0) {


                    System.out.println(places[0].jetons + " chario dans sec1");
                    System.out.println(places[1].jetons + " chario dans sec2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, Controller.this.t15);
                        }
                    });
                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p11, 1);

                    Controller.this.addValue(Controller.this.p21, -1);
                    System.out.println(++places[0].jetons + " chario dans sec1");
                    System.out.println(--places[1].jetons + " chario dans sec2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
            })).run();

            (new Thread(() -> {

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });

                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[14].jetons > 0) {

                    System.out.println(places[10].jetons + " chario dans Mvt5 ");
                    System.out.println(places[14].jetons + "chario dans porte 4");
                    Controller.this.addValue(Controller.this.p52, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t43);
                        }
                    });

                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p43, -1);
                    System.out.println(++places[10].jetons + " chario dans Mvt5");
                    System.out.println(--places[14].jetons + "chario dans porte 4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[13].jetons > 0) {

                    System.out.println(places[9].jetons + " chario dans Mvt4  ");
                    System.out.println(places[13].jetons + " chario dans porte3");
                    Controller.this.addValue(Controller.this.p42, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t33);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p33, -1);
                    System.out.println(--places[13].jetons + " chario dans porte3");
                    System.out.println(++places[9].jetons + " chario dans Mvt4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[0].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1  ");
                    System.out.println(places[0].jetons + " chario dans sec 1");
                    Controller.this.addValue(Controller.this.p12, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t11);
                        }
                    });

                    transitions[0].activate();

                    Controller.this.addValue(Controller.this.p11, -1);
                    System.out.println(--places[0].jetons + " chario dans sec 1");
                    System.out.println(++places[6].jetons + " chario dans Mvt1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

            })).run();


            (new Thread(() -> {

                if (places[4].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p41, 1);

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    System.out.println(++places[3].jetons + " chario dans sec4");


                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });
                    transitions[10].activate();


                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[10].jetons > 0) {
                    System.out.println(places[10].jetons + " chario dans Mvt5");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t51);
                        }
                    });
                    transitions[8].activate();

                    Controller.this.addValue(Controller.this.p53, 1);
                    Controller.this.addValue(Controller.this.p52, -1);

                    System.out.println(--places[10].jetons + " chario dans Mvt5");
                    System.out.println(++places[15].jetons + " chario dans porte 5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });

                    transitions[1].activate();

                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[6].jetons > 0) {

                    System.out.println(places[6].jetons + " chario dans Mvt1 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p13, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t12);
                        }
                    });

                    transitions[5].activate();

                    Controller.this.addValue(Controller.this.p12, -1);
                    System.out.println(--places[6].jetons + " chario dans Mvt1");
                    System.out.println(++places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons == 0) {
                    if (places[9].jetons > 0) {

                        System.out.println(places[9].jetons + " chario dans Mvt4");
                        System.out.println(places[5].jetons + " chario dans Espace");
                        Controller.this.addValue(Controller.this.p00, 1);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t41);
                            }
                        });
                        transitions[7].activate();

                        Controller.this.addValue(Controller.this.p42, -1);
                        System.out.println(--places[9].jetons + " chario dans Mvt4 ");
                        System.out.println(++places[5].jetons + " chario dans Espace");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            })).run();


            (new Thread(() -> {

                if (places[3].jetons > 0) {
                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[2].jetons + " chario dans sec3");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t34);
                        }
                    });

                    transitions[3].activate();

                    Controller.this.addValue(Controller.this.p31, 1);
                    Controller.this.addValue(Controller.this.p41, -1);
                    System.out.println(++places[2].jetons + " chario dans sec3");
                    System.out.println(--places[3].jetons + " chario dans sec4");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[4].jetons != 0) {

                    System.out.println(places[3].jetons + " chario dans sec4");
                    System.out.println(places[4].jetons + " chario dans sec5");
                    Controller.this.addValue(Controller.this.p41, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t44);
                        }
                    });
                    transitions[4].activate();

                    Controller.this.addValue(Controller.this.p51, -1);
                    System.out.println(++places[3].jetons + " chario dans sec4 ");
                    System.out.println(--places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }


                if (places[15].jetons > 0) {

                    System.out.println(places[4].jetons + " chario dans sec5 ");
                    System.out.println(places[15].jetons + " chario dans porte 5");
                    Controller.this.addValue(Controller.this.p51, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t52);
                        }
                    });

                    transitions[10].activate();

                    Controller.this.addValue(Controller.this.p53, -1);
                    System.out.println(--places[15].jetons + " chario dans porte 5");

                    System.out.println(++places[4].jetons + " chario dans sec5");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons != 0) {

                    if (places[12].jetons == 0) {
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        System.out.println(places[12].jetons + " chario dans porte 2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p22, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        System.out.println(++places[12].jetons + " chario dans porte 2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
                if (places[11].jetons > 0) {

                    System.out.println(places[7].jetons + " chario dans Mvt2 ");
                    System.out.println(places[11].jetons + "chario dans porte 1");
                    Controller.this.addValue(Controller.this.p23, 1);
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Line) Controller.this.t13);
                        }
                    });
                    transitions[1].activate();


                    Controller.this.addValue(Controller.this.p13, -1);
                    System.out.println(++places[7].jetons + " chario dans Mvt2");
                    System.out.println(--places[11].jetons + "chario dans porte 1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }
                if (places[5].jetons > 0) {
                    if (places[0].jetons == 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[0].jetons + " chario dans sec1");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Line) Controller.this.t14);
                            }
                        });
                        transitions[1].activate();

                        Controller.this.addValue(Controller.this.p11, 1);
                        Controller.this.addValue(Controller.this.p00, -1);

                        System.out.println(--places[5].jetons + " chario dans Escpace");
                        System.out.println(++places[0].jetons + " chario dans sec1");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }


                if (places[12].jetons > 0) {
                    System.out.println(places[1].jetons + " chario dans sec 2");
                    System.out.println(places[12].jetons + " chario dans porte 2");
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t23);
                        }
                    });
                    transitions[6].activate();

                    Controller.this.addValue(Controller.this.p21, 1);
                    Controller.this.addValue(Controller.this.p22, -1);

                    System.out.println(++places[1].jetons + " chario dans sec2");
                    System.out.println(--places[12].jetons + " chario dans porte 2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    }
                }

                if (places[5].jetons == 0) {
                    if (places[7].jetons > 0) {
                        System.out.println(places[5].jetons + " chario dans Escpace");
                        System.out.println(places[7].jetons + " chario dans Mvt2");
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Controller.this.travelFromAtoB(20, (Polyline) Controller.this.t21);
                            }
                        });
                        transitions[6].activate();

                        Controller.this.addValue(Controller.this.p00, 1);
                        Controller.this.addValue(Controller.this.p23, -1);

                        System.out.println(++places[5].jetons + " chario dans Escpace");
                        System.out.println(--places[7].jetons + " chario dans Mvt2");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            })).run();
        }


    }
    private void addValue(final Label lbl, final int value) {
        Platform.runLater(new Runnable() {
            public void run() {
                lbl.setText(String.valueOf(Integer.parseInt(lbl.getText()) + value));
            }
        });
    }

    private void travelFromAtoB(int duration, Line path) {
        Circle c = new Circle(5.0);
        c.setStroke(Color.BLACK);
        c.setFill(Color.BLACK);
        this.pane.getChildren().add(c);
        PathTransition t = new PathTransition();
        t.setDuration(Duration.seconds((double)duration));
        t.setNode(c);
        t.setPath(path);
        t.play();
        t.setOnFinished((event) -> {
            this.pane.getChildren().remove(c);
        });
    }

    private void travelFromAtoB(int duration, Polyline path) {
        Circle c = new Circle(5.0);
        c.setStroke(Color.BLACK);
        c.setFill(Color.BLACK);
        this.pane.getChildren().add(c);
        PathTransition t = new PathTransition();
        t.setDuration(Duration.seconds((double)duration));
        t.setNode(c);
        t.setPath(path);
        t.play();
        t.setOnFinished((event) -> {
            this.pane.getChildren().remove(c);
        });
    }


}

