# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Reach Technology boards"

SRC_URI = "git://github.com/jmore-reachtech/reach-imx-linux.git;branch=${SRCBRANCH} \
	   file://defconfig \
"
KBUILD_DEFCONFIG = "imx_g2h_defconfig"

LOCALVERSION = "-2.0.0-ga+yocto"

SRCBRANCH = "reach-imx_4.9.x_1.0_ga"
SRCREV = "c25a70692ed3a01b6df1fd9dfa51da190a178154"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(reach)"
