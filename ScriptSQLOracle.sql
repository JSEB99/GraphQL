DROP USER PROYECTO CASCADE;
CREATE USER PROYECTO IDENTIFIED BY A;
GRANT CONNECT, RESOURCE TO PROYECTO;
ALTER USER PROYECTO QUOTA UNLIMITED ON USERS;
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CONN PROYECTO/A

/*==============================================================*/
/* Creacion de secuencias                                       */
/*==============================================================*/
create sequence SUBTIPO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence TIPO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence APARATO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence COMPONENTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence COMPONENTE_APARATO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence FABRICANTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence CLIENTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence REPARACION_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence MODIFICACION_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;

/*==============================================================*/
/* Creacion de tablas                                           */
/*==============================================================*/
CREATE TABLE SUBTIPOS(
SUBTIPO_ID NUMBER DEFAULT SUBTIPO_SEQ.NEXTVAL,
DESCRIPCION VARCHAR(250),
constraint PK_SUBTIPO primary key (SUBTIPO_ID)
);

CREATE TABLE TIPOS(
TIPO_ID NUMBER DEFAULT TIPO_SEQ.NEXTVAL,
DESCRIPCION VARCHAR(250),
CARACTERISTICAS VARCHAR(250),
SUBTIPO_ID NUMBER,
constraint PK_TIPO primary key (TIPO_ID)
);

CREATE TABLE APARATOS_ELECTRONICOS(
APARATO_ID NUMBER DEFAULT APARATO_SEQ.NEXTVAL,
DESCRIPCION VARCHAR(250),
TIPO_ID NUMBER,
constraint PK_APARATO primary key (APARATO_ID)
);

CREATE TABLE COMPONENTES(
COMPONENTE_ID NUMBER DEFAULT COMPONENTE_SEQ.NEXTVAL,
ESPECIFICACIONES VARCHAR(250),
FABRICANTE_ID NUMBER,
constraint PK_COMPONENTE primary key (COMPONENTE_ID)
);

CREATE TABLE FABRICANTES(
FABRICANTE_ID NUMBER DEFAULT FABRICANTE_SEQ.NEXTVAL, 
RIF VARCHAR(50),
DOMINIO_FISCAL VARCHAR(50),
constraint PK_FABRICANTE primary key (FABRICANTE_ID)
);

CREATE TABLE CLIENTES(
CLIENTE_ID NUMBER DEFAULT CLIENTE_SEQ.NEXTVAL,
NOMBRE VARCHAR(50),
DOCUMENTO NUMBER(20),
DIRECCION VARCHAR(250),
TELEFONO NUMBER(10),
CORREO VARCHAR(100),
constraint PK_CLIENTE primary key (CLIENTE_ID)
);

CREATE TABLE REPARACIONES(
REPARACION_ID NUMBER DEFAULT REPARACION_SEQ.NEXTVAL,
DESCRIPCION VARCHAR(250),
CLIENTE_ID NUMBER,
APARATO_ID NUMBER,
MODIFICACION_ID NUMBER,
FECHA DATE,
constraint PK_REPARACION primary key (REPARACION_ID)
);

CREATE TABLE MODIFICACIONES(
MODIFICACION_ID NUMBER DEFAULT MODIFICACION_SEQ.NEXTVAL,
DESCRIPCION VARCHAR(250),
COMPONENTE_ID NUMBER,
constraint PK_MODIFICACION primary key (MODIFICACION_ID)
);

CREATE TABLE COMPONENTE_APARATO(
COMPONENTE_APARATO_ID NUMBER DEFAULT COMPONENTE_APARATO_SEQ.NEXTVAL,
COMPONENTE_ID NUMBER,
APARATO_ID NUMBER,
CANTIDAD NUMBER,
constraint PK_COMPONENTE_APARATO primary key (COMPONENTE_APARATO_ID)
);

/*==============================================================*/
/* Creacion de foreign keys                                     */
/*==============================================================*/
alter table TIPOS
   add constraint FK_SUBTIPO foreign key (SUBTIPO_ID)
      references SUBTIPOS (SUBTIPO_ID);

alter table APARATOS_ELECTRONICOS
   add constraint FK_TIPO foreign key (TIPO_ID)
      references TIPOS (TIPO_ID);

alter table COMPONENTES
   add constraint FK_FABRICANTE foreign key (FABRICANTE_ID)
      references FABRICANTES (FABRICANTE_ID);

alter table REPARACIONES
   add constraint FK_CLIENTE foreign key (CLIENTE_ID)
      references CLIENTES (CLIENTE_ID);

alter table REPARACIONES
   add constraint FK_APARATO foreign key (APARATO_ID)
      references APARATOS_ELECTRONICOS (APARATO_ID);

alter table REPARACIONES
   add constraint FK_MODIFICACION foreign key (MODIFICACION_ID)
      references MODIFICACIONES (MODIFICACION_ID);

alter table MODIFICACIONES
   add constraint FK_COMPONENTE foreign key (COMPONENTE_ID)
      references COMPONENTES (COMPONENTE_ID);

alter table COMPONENTE_APARATO
   add constraint FK_APARATO2 foreign key (APARATO_ID)
      references APARATOS_ELECTRONICOS (APARATO_ID);

alter table COMPONENTE_APARATO
   add constraint FK_COMPONENTE2 foreign key (COMPONENTE_ID)
      references COMPONENTES (COMPONENTE_ID);