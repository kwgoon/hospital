DROP TABLE patient CASCADE CONSTRAINT;
DROP TABLE medical_record CASCADE CONSTRAINT;
DROP TABLE prescription CASCADE CONSTRAINT;
DROP TABLE treatment CASCADE CONSTRAINT;
DROP SEQUENCE seq_pt_no;
DROP SEQUENCE seq_mr_no;

CREATE TABLE patient (
   pt_no number(3),
   pt_name varchar2(50),
   pt_resident_no varchar2(50),
   pt_address varchar2(50),
   pt_phone varchar2(50),
   CONSTRAINT patient_ptno_pk PRIMARY KEY (pt_no),
   CONSTRAINT patient_ptjumin_pk UNIQUE (pt_resident_no)
);

CREATE TABLE medical_record (
   mr_no number(3),
   pt_no number(3),
   mr_diagnosis varchar2(50),
   mr_date date,
   CONSTRAINT medical_mrno_pk PRIMARY KEY (mr_no),
   CONSTRAINT medical_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

CREATE TABLE prescription (
   mr_no number(3),
   medicine varchar2(50),
   times number(1),
   days number(1),
   CONSTRAINT pre_mrno_fk FOREIGN KEY (mr_no) REFERENCES medical_record (mr_no)
);

CREATE TABLE treatment (
   pt_no number(3),
   state number(1) CONSTRAINT treatment_state_ck CHECK (state IN (0, 1)),
   CONSTRAINT treatment_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

CREATE SEQUENCE seq_pt_no; 
CREATE SEQUENCE seq_mr_no; 

CREATE OR REPLACE TRIGGER receipt
AFTER
	INSERT ON patient
	FOR EACH ROW
BEGIN
	INSERT INTO treatment VALUES(:new.pt_no, 0);
END;
/

CREATE OR REPLACE TRIGGER finishtreatment
AFTER
	INSERT ON medical_record
	FOR EACH ROW
BEGIN
	DELETE treatment WHERE pt_no = :new.mr_no;
END;
/

insert into patient values (seq_pt_no.nextval, 'name', 'jumin','add','phone');
insert into medical_record values (seq_mr_no.nextval, 1, 'die', sysdate);
insert into prescription values (1, 'medicine1', 3, 3);
insert into prescription values (1, 'medicine2', 3, 3);