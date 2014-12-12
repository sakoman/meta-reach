DESCRIPTION = "Reach TIO agent"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRCREV = "bce814f6c13d958427bf61e793b142fb3102bb4e"
SRC_URI = "git://git@github.com/jmore-reachtech/reach-tio-agent.git;protocol=ssh \
		   file://tio-agent \
          "
          
FILES_${PN} += "${sysconfdir}/init.d/tio-agent"

S = "${WORKDIR}/git"

CFLAGS += " -DTIO_VERSION='"${PV}"'"

do_compile() {
		cd ${S} && ${MAKE}
}

do_install() {
	install -d ${D}/application/bin
	install -m 0755 ${S}/src/tio-agent ${D}/application/bin/tio-agent

	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/tio-agent ${D}${sysconfdir}/init.d/tio-agent
}

FILES_${PN} += "/application/bin"
FILES_${PN}-dbg += "/application/bin/.debug /usr/src/debug"

inherit update-rc.d

INITSCRIPT_NAME = "tio-agent"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."