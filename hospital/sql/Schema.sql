DROP TABLE patient CASCADE CONSTRAINT;
DROP TABLE medical_record CASCADE CONSTRAINT;
DROP TABLE prescription CASCADE CONSTRAINT;
DROP TABLE treatment CASCADE CONSTRAINT;
DROP SEQUENCE seq_pt_no;
DROP SEQUENCE seq_mr_no;

--환자 번호, 환자 이름, 주민번호, 주소, 전화번호 
CREATE TABLE patient (
   pt_no number(3),
   pt_name varchar2(50),
   pt_resident_no varchar2(50),
   pt_address varchar2(50),
   pt_phone varchar2(50),
   CONSTRAINT patient_ptno_pk PRIMARY KEY (pt_no),
   CONSTRAINT patient_ptjumin_pk UNIQUE (pt_resident_no)
);

--진료 번호, 환자 번호, 진단, 진료날짜
CREATE TABLE medical_record (
   mr_no number(3),
   pt_no number(3),
   mr_diagnosis varchar2(50),
   mr_date date,
   CONSTRAINT medical_mrno_pk PRIMARY KEY (mr_no),
   CONSTRAINT medical_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

--진료 번호, 처방약, 1일 ?회, 투여일
CREATE TABLE prescription (
   mr_no number(3),
   medicine varchar2(50),
   times number(1),
   days number(1),
   CONSTRAINT pre_mrno_fk FOREIGN KEY (mr_no) REFERENCES medical_record (mr_no)
);

--환자 번호, 진료 상태(대기(0), 진료중(1), 진료완료(삭제))
CREATE TABLE treatment (
   pt_no number(3),
   state number(1) CONSTRAINT treatment_state_ck check(state in (0, 1)),
   CONSTRAINT treatment_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

CREATE SEQUENCE seq_pt_no; 
CREATE SEQUENCE seq_mr_no; 

-- 새 환자 등록 후 접수 처리 트리거
CREATE OR REPLACE TRIGGER receipt
AFTER
	INSERT ON patient
	for each row
BEGIN
	INSERT INTO treatment VALUES(:new.pt_no, 0);
END;
/

-- 새 진료 기록이 저장되면 해당 환자 진료완료 처리하는 트리거
CREATE OR REPLACE TRIGGER finishtreatment
AFTER
	INSERT ON medical_record
	for each row
BEGIN
	DELETE treatment WHERE pt_no = :new.mr_no;
END;
/


insert into patient values (seq_pt_no.nextval, '이름', '주민','주소','폰');
insert into medical_record values (seq_mr_no.nextval, 1, '병명', sysdate);
insert into prescription values (1, '약1', 3, 3);
insert into prescription values (1, '약2', 3, 3);