
INSERT INTO STUDENT ( ID , NAME ) VALUES (7,'Barry');

INSERT INTO ATTENDANCE_STUDENT (ID ,CREATED_AT ,NOTE) VALUES (5, now(), 'Lista de chamada');

INSERT INTO ATTENDANCE ( ID , PRESENCE , ATTENDANCE_STUDENT_ID , STUDENT_ID ) VALUES (19, TRUE , 5 ,7);

INSERT INTO ATTENDANCE_STUDENT_ATTENDANCE (ATTENDANCE_STUDENT_ID ,ATTENDANCE_ID ) VALUES (5,19);

INSERT INTO LECTURER (ID , NAME ) VALUES (123456, 'Joe');

INSERT INTO SUBJECT ( ID , NAME ) VALUES (3, 'Engenharia da Computação');

INSERT INTO CLASS_COURSE ( ID , LECTURER_ID , SUBJECT_ID)  VALUES  (28, 123456, 3);

INSERT INTO LESSON (ID ,CONTENT ,DATE ,NUMBER_CLASSES ,ATTENDANCE_STUDENT_ID ,CLASS_COURSE_ID) VALUES (75, 'Lista Encadeada', '2018-10-5', 2, 5, 28);

INSERT INTO ANTICIPATION ( ID , MODALITIE , NEXT_DATE , NUMBER_CLASSES ,DESCRIPTION_REASON , REASON_BY ) VALUES (1,'PRESENCIAL','2018-9-2',3,'Viagem',  'PREVISTO');

INSERT INTO DEPARTMENT  (id, name) VALUES (1, 'Computação');
