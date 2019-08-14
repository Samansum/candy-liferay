#!/bin/bash
#
# @author:	Ricardo Wagemaker (["java"] + "@" + "wagemaker.co.uk") 2019-2019
# @name:	InstallMariaDB-10.3.13_on_Ubuntu1904
# @description: Simple MariaDB installation on Ubuntu1904
# @created: 	Thu  4 Apr 15:06:48 BST 2019
# @updated: 	Thu  4 Apr 15:06:48 BST 2019
# @tested:	Ubuntu 19.04
# @License:	MIT - http://www.wagemaker.co.uk/?page_id=995
#
#################################################################
# NOTES & INSTRUCTIONS 						#
#################################################################
#
# @NOTE:	MAKE CHANGES TO THE RECOMMENED VARIABLES AS YOU SEE FIT AND APPROPRIATE
# @WARNING:	ANY MODIFICATIONS OUTSIDE THE RECOMMENDED VARIABLES IS AT YOUR OWN RISK
# @NOTE:	AUTOMATIC UPDATE WILL PRESERVE THE RECOMMENDED VARIABLES AND BACKUP COUNTER
#
#################################################################
#
# Insert progress bar funtion for download
progressfilt ()
{
    local flag=false c count cr=$'\r' nl=$'\n'
    while IFS='' read -d '' -rn 1 c
    do
        if $flag
        then
            printf '%s' "$c"
        else
            if [[ $c != $cr && $c != $nl ]]
            then
                count=0
            else
                ((count++))
                if ((count > 1))
                then
                    flag=true
                fi
            fi
        fi
    done
}
#############################################
echo "####################### Checking if user is root"
/usr/bin/whoami | grep root >/dev/null 2>&1
if [ $? != 0 ];then
	echo ""
	echo "Exec: sudo $0"
	echo ""
	exit 1
fi

echo "####################### Change to /tmp"
cd /tmp

echo "####################### Download mariadb-10.3.13"
if [ ! -f /tmp/mariadb-10.3.13-linux-x86_64.tar.gz ];then
	/usr/bin/wget https://downloads.mariadb.org/interstitial/mariadb-10.3.13/bintar-linux-x86_64/mariadb-10.3.13-linux-x86_64.tar.gz 2>&1 | progressfilt
fi

echo "####################### Checking missing libraries"
/usr/bin/dpkg --list | grep libaio 
if [ $? != 0 ]; then
	echo "####################### Installing missing libraries"
	apt-get -y install libaio1
fi

echo "####################### Create mysql group"
groupadd mysql

echo "####################### Create mysql user and add to mysql group"
useradd -g mysql mysql

echo "####################### Change to /usr/local"
cd /usr/local

read -p "####################### Extract downloaded file! Continue? (y/n) " -n 1 -r
echo
if [[ $REPLY =~ ^[Yy]$ ]];then
	if [ -f /tmp/mariadb-10.3.13-linux-x86_64.tar.gz ];then
		gunzip -c /tmp/mariadb-10.3.13-linux-x86_64.tar.gz | tar -xv
	else
		echo "####################### Unable to file downloaded file, please check in tmp and try again"
		exit 1
	fi
else
	echo "Stopped Installation"
	exit 0
fi

echo "####################### Create link from extracted folder to mysql"
ln -s mariadb-10.3.13-linux-x86_64 mysql

echo "####################### Change folder to mysql"
cd mysql

echo "####################### Change permission to mysql user"
chown -R mysql .
chgrp -R mysql .

echo "####################### Run mariadb db installer"
scripts/mysql_install_db --user=mysql
sleep 1

echo "####################### Change permission to root"
chown -R root .

echo "####################### Change data folder permission to mysql"
chown -R mysql data

echo "####################### Start DB in safe mode"
sleep 1
bin/mysqld_safe --user=mysql & > /dev/null 2>&1
sleep 1

echo "####################### Set root password for databases"
echo ""
read -p "Provide root password for MariaDB: " pass1
read -sp "Repeat root password for MariaDB: " pass2
echo ""
echo ""
if [ $pass1 == $pass2 ]; then
	bin/mysqladmin -u root password $pass1
else
	echo "####################### ROOT password does not match"
	exit 1
fi

echo "####################### Checking Mysql / MariaDB client"

/usr/bin/dpkg --list | grep mariadb-client
if [ $? != 0 ]; then
	echo "####################### Installing MariaDB client"
	apt-get -y install mariadb-client
fi

echo "####################### Shutdown MySql safemode services"
pkill mysql

echo "####################### Preparing mysql.service file in init.d"
cp -v /usr/local/mysql/support-files/mysql.server /etc/init.d/mysql.server

echo "####################### Initiate rc scripts for mysql.service"
update-rc.d mysql.server defaults
sleep 2

echo "####################### Start MariaDB services"
/etc/init.d/mysql.server start
sleep 3

echo "####################### Check MariaDB Services status"
/etc/init.d/mysql.server status
echo ""
echo "#####################################################################"
echo "Now ready to connect try: $ mysql -u root -p -h 127.0.0.1"
echo "#####################################################################"
echo ""
