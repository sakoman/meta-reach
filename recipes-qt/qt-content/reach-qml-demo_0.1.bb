DESCRIPTION = "Reach qml-viewer demo content and plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r3"

SRCREV = "cab913b63957ebe23dbea60bf054fb066eb8fac2"
SRC_URI = "git://git@github.com/jmore-reachtech/reach-qml-demo.git;protocol=ssh"

S_BASE = "${WORKDIR}/git/src"
APP_DIR = "/application/src"

do_install() {
        install -d ${D}${APP_DIR}

        cp -rf ${S_BASE}`echo "${MACHINE}" | cut -c4-`/*   ${D}${APP_DIR}
}

FILES_${PN} = "${APP_DIR}"

