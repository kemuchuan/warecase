create table pallet
(
    palletid    int          not null
        primary key,
    arrivaldate date         not null,
    number      int          not null,
    lorryid     varchar(100) not null
);

create table product
(
    serial_id varchar(255) not null
        primary key,
    name      varchar(255) null,
    category  varchar(255) null,
    order_no  int          null
);

create table productpallet
(
    productID       varchar(10) not null,
    palletid        int         not null,
    assignment_date date        not null,
    primary key (productID, palletid),
    constraint ProductPallet_FK_1
        foreign key (palletid) references pallet (palletid),
    constraint productpallet_product_FK
        foreign key (productID) references product (serial_id)
);

create table statistics
(
    statistics_id int          not null
        primary key,
    name          varchar(100) not null,
    totalreturned varchar(100) not null,
    totalrepair   varchar(100) not null,
    totalrefund   varchar(100) not null,
    totalrecycle  varchar(100) not null
);

create table user
(
    user_id    varchar(100) not null
        primary key,
    name       varchar(100) not null,
    permission varchar(100) not null
);

create table returndatails
(
    return_id   varchar(100) not null
        primary key,
    userId      varchar(100) not null,
    return_type varchar(100) not null,
    return_date date         not null,
    serial_id   varchar(100) null,
    constraint ReturnDatails_product_FK
        foreign key (serial_id) references product (serial_id),
    constraint ReturnDatails_user_FK
        foreign key (userId) references user (user_id)
);


