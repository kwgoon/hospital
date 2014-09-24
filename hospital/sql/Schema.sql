DROP TABLE patient CASCADE CONSTRAINT;
DROP TABLE medical_record CASCADE CONSTRAINT;
DROP TABLE prescription CASCADE CONSTRAINT;
DROP TABLE treatment CASCADE CONSTRAINT;

--환자 번호, 환자 이름, 주민번호, 주소, 전화번호 
CREATE TABLE patient (
	pt_no number(3),
	pt_name varchar2(50),
	pt_resident_no varchar2(50),
	pt_address varchar2(50),
	pt_phone varchar2(50),
	CONSTRAINT patient_ptno_pk PRIMARY KEY (pt_no),
	CONSTRAINT patient_ptjumin_pk UNIQUE (pt_jumin)
);

--진료 번호, 환자 번호(fk), 진단, 진료날짜
CREATE TABLE medical_record (
	mr_no number(3),
	pt_no number(3),
	mr_diagnosis varchar2(50),
	mr_date date,
	CONSTRAINT medical_mrno_pk PRIMARY KEY (mr_no),
	CONSTRAINT medical_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

--진료 번호(fk), 처방약, 1일 ?회, 투여일
CREATE TABLE prescription (
	mr_no number(3),
	medicine varchar2(50),
	times number(1),
	days number(1),
	CONSTRAINT pre_mrno_fk FOREIGN KEY (mr_no) REFERENCES medical_record (mr_no)
);

--환자 번호(fk), 진료 상태(대기, 진료중, 진료완료)
CREATE TABLE treatment (
	pt_no number(3),
	state number(1),
	CONSTRAINT treatment_ptno_fk FOREIGN KEY (pt_no) REFERENCES patient (pt_no)
);

insert into patient values (1, '이름', '주민','주소','폰');
insert into medical_record values (1, 1, '병명', sysdate);
insert into prescription values (1, '약1', 3, 3);
insert into prescription values (1, '약2', 3, 3);