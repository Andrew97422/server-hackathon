INSERT INTO Roles VALUES
                      (DEFAULT, 'Сотрудник'),
                      (DEFAULT, 'Менеджер');


INSERT INTO TASK_Statuses VALUES
                              (DEFAULT, 'Открыта', 0.0),
                              (DEFAULT, 'Закрыта в срок', 1.0),
                              (DEFAULT, 'Просрочена', -0.5),
                              (DEFAULT, 'Выполнена с просрочкой', 0.5),
                              (DEFAULT, 'Провалена', -1.0);

INSERT INTO Restaurants VALUES
                            (DEFAULT, 'улица Южная 25', 'Магадан'),
                            (DEFAULT, 'улица Мирная 45', 'Тверь'),
                            (DEFAULT, 'улица Планерная 13', 'Москва'),
                            (DEFAULT, 'улица Маркса 8', 'Обнинск'),
                            (DEFAULT, 'улица Янтарная 12', 'Калининград');

INSERT INTO Employers VALUES
                          (DEFAULT, 'Слойко Юрий Геннадьевич', '+7 915 874 90 12', 1, 2, 'Sloyko@yandex.ru', '$2a$08$StTQlpaXy08j1BI.PJGAOu.nj069q3HVv1iBYG3tQdWq6Pov4mrZG'),
                          (DEFAULT, 'Орлова Любовь Игоревна', '+7 910 547 35 37', 1, 1, 'Orlova@yandex.ru', '$2a$08$aiLaiV0uyya1rV3wHTRoIu1KO5rF0rASbW8HBczclJRH.aWpcOxiC'),
                          (DEFAULT, 'Чирпых Анна Георгиевна', '+7 910 876 12 01', 2, 2, 'Chirpx@yandex.ru', '$2a$08$3JMELY9or4C6lME60ik9A.veNUfCdDl3aS/LmwwDVgoTAH8fgfjN2'),
                          (DEFAULT, 'Дужев Ян Павлович', '+7 980 882 74 87', 2, 1, 'Duzhev@yandex.ru', '$2a$08$5dloFTpZFpuBtdipp9IdJemhxV1UBRKg42eUSiGCZXvb2kvYZUUbC'),
                          (DEFAULT, 'Выкулин Борис Михайлович', '+7 980 525 86 68', 3, 2, 'Vkulin@yandex.ru', '$2a$08$XgFmPxco3hVT93CfsfjRH.f05pwcA.lmKU4ovC3k1r0w0mLgFQz8m'),
                          (DEFAULT, 'Кузейников Игорь Олегович', '+7 910 654 34 90', 3, 1, 'Kuzeinikov@yandex.ru', '$2a$08$U4P1TCaLqVLoPZvRjS.sfOgYRCUE/qtLsDg6tv/vlnbbTpz5y52Uq'),
                          (DEFAULT, 'Зубенко Михайл Петрович', '+7 915 872 47 34', 4, 2, 'Zubenko@yandex.ru', '$2a$08$q64I7h8vLyOwjS/6BNyWquXTfn0ekpyjNBczuSR.ApciliADLpt72'),
                          (DEFAULT, 'Морская Наталья Пехотовна', '+7 910 678 12 09', 4, 1, 'Morskaya@yandex.ru', '$2a$08$xld8dr/acNEKAdR8FU3g8OHdad8yX2NZap9Yw/kuAlHlC4wdcwxIG'),
                          (DEFAULT, 'Козубенко Регина Ильинична', '+7 910 332 50 08', 5, 2, 'Kozubenko@yandex.ru', '$2a$08$uNT4a1Ijz5sxcEMIiUFyH.bRIEgGOJm1qoU7u0DQank80a9SlUHDi'),
                          (DEFAULT, 'Панков Андрей Георгиевич', '+7 980 654 13 98', 5, 1, 'Pankov@yandex.ru', '$2a$08$5b5Ly6IxuldapuzJfT17feH5INbFbjCmd4U3MLVr4sa8PSLRfs.YO'),
                          (DEFAULT, 'Ханас Василий Дмитриевич', '+7 910 547 90 90', 1, 2, 'Hanas@yandex.ru', '$2a$08$itWkQ6/OFq0mIl5tjOA53us331g2WqW3CX2lERz9dT6qrtDohJZGW'),
                          (DEFAULT, 'Жукова Лидия Георгиевна', '+7 910 561 17 89', 1, 1, 'ZukovaI@yandex.ru', '$2a$08$KlTP0tnbqJSMKXzpaxCNN.234YJgrDVisPnNmWVpq.mRjhf8qYK8a'),
                          (DEFAULT, 'Жукова Людмила Георгиевна', '+7 980 112 67 36', 2, 2, 'ZukovaU@yandex.ru', '$2a$08$oN/1lGZpC4EBzwkpThI0BOAC6vV3wTF5RmLgvQm6Cj3.SMgeDEOgy'),
                          (DEFAULT, 'Уткин Георгий Владимирович', '+7 910 561 34 67', 2, 1, 'Utkin@yandex.ru', '$2a$08$Bc7B32W3wDHCY1gjeWUa8eASMaTM0nLxnB4YSpIRKpRFPVZqr/5/m'),
                          (DEFAULT, 'Калинина Лидия Георгиевна', '+7 910 457 12 89', 3, 2, 'Kalinina@yandex.ru', '$2a$08$RWUtaoRHrFYwbqwHrghjhOs/aBnQ.HFkV0W7b.jM1CEvHfWzYU27O'),
                          (DEFAULT, 'Работин Александр Александрович', '+7 980 561 17 89', 3, 1, 'Rabotin@yandex.ru', '$2a$08$4tPNpNoYQRM7x4LhyqlY.u88lkZf3wpuXgI9wwqyusAHRK8Hz7Qt.'),
                          (DEFAULT, 'Юрьев Юрий Павлович', '+7 910 781 67 89', 4, 2, 'Uriev@yandex.ru', '$2a$08$Qdmyc4pErQxhg3ZkDjHZ6OT7rd0hBHFOCiEfrJGd2icSuyJLqBXz6'),
                          (DEFAULT, 'Александров Александр Александрович', '+7 910 554 17 78', 4, 1, 'AlexAlexAlex@yandex.ru', '$2a$08$2RUCHRoQgXovn9MllPsr4.Aqx7yOAWi9hIaTXX3s1N2KW4WN3CF/W'),
                          (DEFAULT, 'Иванова Елена Борисовна', '+7 980 543 15 65', 5, 2, 'Ivanova@yandex.ru', '$2a$08$oYpPvyd04guVuec5psxLi.LyugKIx.kNcGTkXE3cxkJEM/5sMuxKq'),
                          (DEFAULT, 'Егорова Алена Дмитриевна', '+7 910 561 45 88', 5, 1, 'Egorova@yandex.ru', '$2a$08$anLhQzxa70kTIWUGb69qreiSJIRqH3Qs50U7gTJIfMcus7bWIpYWu');

INSERT INTO Task_Templates VALUES
                               (DEFAULT, 'Помыть полы', NULL),
                               (DEFAULT, 'Помыть посуду', NULL),
                               (DEFAULT, 'Провести уборку зала', NULL),
                               (DEFAULT, 'Сформировать стоп-лист', NULL),
                               (DEFAULT, 'Контроль расчета посетителей с официантами', NULL),
                               (DEFAULT, 'Отбор продуктов', NULL),
                               (DEFAULT, 'Приготавление блюда', NULL),
                               (DEFAULT, 'Маркировка заготовок', NULL),
                               (DEFAULT, 'Помыть рабочие места', NULL),
                               (DEFAULT, 'Контроль сервировки, чистоты столов', NULL),
                               (DEFAULT, 'Сгонять за энергосом', NULL);

INSERT INTO TASKS VALUES
                      (DEFAULT, GetEmployId('Слойко Юрий Геннадьевич'), NULL, NULL, GetTaskTemplId('Помыть полы'), 5.0, GetTaskStatusId('Открыта'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Орлова Любовь Игоревна'), NULL, NULL, GetTaskTemplId('Помыть посуду'), 5.0, GetTaskStatusId('Закрыта в срок'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Чирпых Анна Георгиевна'), NULL, NULL, GetTaskTemplId('Провести уборку зала'), 5.0, GetTaskStatusId('Просрочена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Дужев Ян Павлович'), NULL, NULL, GetTaskTemplId('Сформировать стоп-лист'), 5.0, GetTaskStatusId('Выполнена с просрочкой'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Выкулин Борис Михайлович'), NULL, NULL, GetTaskTemplId('Контроль сервировки, чистоты столов'), 5.0, GetTaskStatusId('Открыта'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Кузейников Игорь Олегович'), NULL, NULL, GetTaskTemplId('Контроль расчета посетителей с официантами'), 5.0, GetTaskStatusId('Провалена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Зубенко Михайл Петрович'), NULL, NULL, GetTaskTemplId('Отбор продуктов'), 5.0, GetTaskStatusId('Просрочена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Морская Наталья Пехотовна'), NULL, NULL, GetTaskTemplId('Приготавление блюда'), 5.0, GetTaskStatusId('Закрыта в срок'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Козубенко Регина Ильинична'), NULL, NULL, GetTaskTemplId('Маркировка заготовок'), 5.0, GetTaskStatusId('Выполнена с просрочкой'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Панков Андрей Георгиевич'), NULL, NULL, GetTaskTemplId('Помыть рабочие места'), 5.0, GetTaskStatusId('Провалена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Ханас Василий Дмитриевич'), NULL, NULL, GetTaskTemplId('Контроль сервировки, чистоты столов'), 5.0, GetTaskStatusId('Открыта'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Жукова Лидия Георгиевна'), NULL, NULL, GetTaskTemplId('Сгонять за энергосом'), 5.0, GetTaskStatusId('Выполнена с просрочкой'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Жукова Людмила Георгиевна'), NULL, NULL, GetTaskTemplId('Помыть посуду'), 5.0, GetTaskStatusId('Провалена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Уткин Георгий Владимирович'), NULL, NULL, GetTaskTemplId('Провести уборку зала'), 5.0, GetTaskStatusId('Закрыта в срок'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Калинина Лидия Георгиевна'), NULL, NULL, GetTaskTemplId('Помыть полы'), 5.0, GetTaskStatusId('Просрочена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Работин Александр Александрович'), NULL, NULL, GetTaskTemplId('Приготавление блюда'), 5.0, GetTaskStatusId('Открыта'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Юрьев Юрий Павлович'), NULL, NULL, GetTaskTemplId('Контроль расчета посетителей с официантами'), 5.0, GetTaskStatusId('Выполнена с просрочкой'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Александров Александр Александрович'), NULL, NULL, GetTaskTemplId('Маркировка заготовок'), 5.0, GetTaskStatusId('Закрыта в срок'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Иванова Елена Борисовна'), NULL, NULL, GetTaskTemplId('Контроль сервировки, чистоты столов'), 5.0, GetTaskStatusId('Провалена'), FALSE, FALSE, 0),
                      (DEFAULT, GetEmployId('Егорова Алена Дмитриевна'), NULL, NULL, GetTaskTemplId('Сформировать стоп-лист'), 5.0, GetTaskStatusId('Выполнена с просрочкой'), FALSE, FALSE, 0);