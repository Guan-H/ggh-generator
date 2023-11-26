<template>
    <!-- action -->
    <page-view title="${title!"标题为空"}">
        <template slot="action">
            <a-row>
                <a-button-group>
                    <a-button type="primary" @click="onAdd" icon="plus">${title!"标题为空"}</a-button>
                </a-button-group>
            </a-row>
        </template>
        <a-card>
            <a-row>
                <a-form :form="form" class="pick-100 form-input about">
                    <a-row>
                        <#list colList as col>
                        <#if col?index%2 != 0>
                        <a-col :span="11">
                            <a-form-item label="${col.label!"number为空"}">
                                <a-input v-model="queryParam.${col.queryParam!""}"/>
                            </a-form-item>
                        </a-col>
                        <#else>
                    </a-row>
                    <a-row>
                        <a-col :span="11">
                            <a-form-item label="${col.label!"number为空"}">
                                <a-input v-model="queryParam.${col.queryParam!""}"/>
                            </a-form-item>
                        </a-col>
                        </#if>
                        </#list>
                    </a-row>
                        <a-row>
                            <a-col :span="24" class="footer-button">
                                <a-form-item :wrapperCol="{ span: 23 }" style="text-align: center">
                                    <a-button type="primary" @click="onSearch">查询</a-button>
                                    <a-button @click="reset" style="margin-left: 20px">重置</a-button>
                                </a-form-item>
                            </a-col>
                        </a-row>
                </a-form>
            </a-row>
        </a-card>
    </page-view>
</template>

<script>
    import {PageView} from "@/layouts";
    import STable from "@/components/Table";
    import qs from "qs";

    export default {
        components: {STable, PageView},
        data() {
            return {
                form: this.$form.createForm(this),
                caseTypeId: this.$route.query.caseTypeId,
                queryParam: {
                    <#list colList as col>
                    ${col.queryParam}: '',
                    </#list>
                },
            };
        },
        methods: {
            onAdd() {
                this.$router.push({path: "/tclientmeals/tclientmealsadd?caseTypeId=" + this.caseTypeId});
            },
            onSearch() {
                this.$refs.table.refresh();
            },
            reset() {
                this.queryParam = {
                    <#list colList as col>
                    ${col.queryParam}: '',
                    </#list>
                }
                this.$refs.table.refresh();
            },
        },
        mounted() {
        },
    };
</script>

<style lang="scss" scoped>

</style>
