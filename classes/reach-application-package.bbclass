# Provide common variables for use when doing Reach Technology
# Inc. application packages.
#
# Copyright 2015 (C) O.S. Systems Software LTDA.

APP_SRC_DESTDIR = "/application/src"
APP_BIN_DESTDIR = "/application/bin"
PLUGIN_DESTDIR = "/application/plugins"

FILES_${PN} += "${APP_SRC_DESTDIR} \
                ${APP_BIN_DESTDIR} \
                ${PLUGIN_DESTDIR}"
FILES_${PN}-dbg += "${APP_SRC_DESTDIR}.debug \
                    ${APP_BIN_DESTDIR}/.debug \
                    ${PLUGIN_DESTDIR}/.debug"