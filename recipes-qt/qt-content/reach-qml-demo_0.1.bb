DESCRIPTION = "Reach qml-viewer demo content and plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r3"

SRCREV = "c52ad081a1d3aec1d739f41f4beca7b1a1a841d3"
SRC_URI = "git://git@github.com/jmore-reachtech/reach-qml-demo.git;protocol=http"

S_BASE = "${WORKDIR}/git/src"
APP_DIR = "/application/src"

do_install() {
        install -d ${D}${APP_DIR}

        cp -rf ${S_BASE}`echo "${MACHINE}" | cut -c4-`/*   ${D}${APP_DIR}
}

FILES_${PN} = "${APP_DIR}"

