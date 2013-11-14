# Copyright (C) 2011-2012 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

PR = "${INC_PR}.22"

include linux-g2.inc

COMPATIBLE_MACHINE = "(g2c|g2s)"

SRC_URI_append_g2c += "git://github.com/jmore-reachtech/reach-imx-linux.git;branch=imx-2.6.35-mx28-next;protocol=git \
"
SRCREV_g2c = "2a9fa3b891e4190cf6ff7d2116d13eb0eab09284"
LOCALVERSION_g2c = "-10.12.01+yocto"

#SRC_URI_append_g2s = "git://github.com/jmore-reachtech/reach-imx-linux.git;branch=imx-2.6.35-mx53-next;protocol=git \
#"

SRC_URI_append_g2s = "git:///home/reach/Projects/reach-imx-linux;branch=merge-maintain;protocol=file \
"

SRCREV_g2s = "63ae358ae44f0e8a5d1927bac0973e30348a8b14"
LOCALVERSION_g2s = "-11.09.01+yocto"

