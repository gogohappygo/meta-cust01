SUMMARY = "Configuration file for Kera API"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://kera-api.conf"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/kera-api
    install -m 0644 ${WORKDIR}/kera-api.conf ${D}${sysconfdir}/kera-api/kera-api.conf
}

FILES:${PN} += "${sysconfdir}/kera-api/kera-api.conf"
