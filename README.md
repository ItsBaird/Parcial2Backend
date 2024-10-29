Scripts base de datos postresql Parcial 2

Base de datos:
CREATE DATABASE parqueadero
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

Tabla users:
CREATE TABLE public.users
(
    user_id serial NOT NULL,
    username character varying(150) NOT NULL,
    password character varying(100) NOT NULL,
    CONSTRAINT "user_id_PK" PRIMARY KEY (user_id)
);

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

Tabla roles:
CREATE TABLE public.roles
(
    role_id serial NOT NULL,
    name character varying(150) NOT NULL,
    CONSTRAINT "role_id_PK" PRIMARY KEY (role_id)
);

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

-Tabla users_roles
CREATE TABLE public.users_roles
(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT "user_id_FK" FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.users_roles
    OWNER to postgres;

-Actualizar users_roles para relacionar con roles
ALTER TABLE IF EXISTS public.users_roles
    ADD CONSTRAINT "role_id_FK" FOREIGN KEY (role_id)
    REFERENCES public.roles (role_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

-Tabla tipovehiculo
CREATE TABLE public.tipovehiculo
(
    tipovehiculo_id serial NOT NULL,
    name character varying(150) NOT NULL,
    CONSTRAINT "tipovehiculo_id_PK" PRIMARY KEY (tipovehiculo_id)
);

ALTER TABLE IF EXISTS public.tipovehiculo
    OWNER to postgres;

-Tabla iovehiculos
CREATE TABLE public."iovehiculos"
(
    id serial NOT NULL,
    placa_vehiculo character varying NOT NULL,
    hora_entrada integer NOT NULL,
    hora_salida integer,
    ubicacion character varying NOT NULL,
    tipo_vehiculo_id integer NOT NULL,
    CONSTRAINT "id_PK" PRIMARY KEY (id),
    CONSTRAINT "tipo_vehiculo_id_FK" FOREIGN KEY (tipo_vehiculo_id)
        REFERENCES public.tipovehiculo (tipovehiculo_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."iovehiculos"
    OWNER to postgres;

-Update iovehiculos 
ALTER TABLE public.iovehiculos
    ALTER COLUMN placa_vehiculo TYPE character varying(6) COLLATE pg_catalog."default";

ALTER TABLE public.iovehiculos
    ALTER COLUMN ubicacion TYPE character varying(250) COLLATE pg_catalog."default";

-Modificar tipovehiculos para cambiar nombre columna
ALTER TABLE IF EXISTS public.tipovehiculo
    RENAME tipovehiculo_id TO tipo_vehiculo_id;


-Insert en tipovehiculo
insert into tipovehiculo(name)
values('Automovil');

insert into tipovehiculo(name)
values('Motocicleta');

insert into tipovehiculo(name)
values('Camion');

-Insert en roles
insert into roles(role_id, name)
values(1, 'Administrador');
insert into roles(role_id, name)
values(2, 'Usuario');

-Insert en users
insert into users(user_id, username, password)
values(1, 'Admin', 'holamundo');
insert into users(user_id, username, password)
values(1, 'User', 'holamundo2');

-Insert en users_roles
insert into users_roles(user_id,role_id)
values(1,1);

insert into users_roles(user_id,role_id)
values(2,2);

