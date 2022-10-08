<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="նޟ״̬" prop="toolstatus">
      <el-input v-model="dataForm.toolstatus" placeholder="նޟ״̬"></el-input>
    </el-form-item>
    <el-form-item label="ѹ݅ƸؗɬӶ" prop="footopenstatus">
      <el-input v-model="dataForm.footopenstatus" placeholder="ѹ݅ƸؗɬӶ"></el-input>
    </el-form-item>
    <el-form-item label="ѹ݅Ƹؗ˵ۘ" prop="footclosestatus">
      <el-input v-model="dataForm.footclosestatus" placeholder="ѹ݅Ƹؗ˵ۘ"></el-input>
    </el-form-item>
    <el-form-item label="Ϡۺ؇Բߪ" prop="cameracoveropenstatus">
      <el-input v-model="dataForm.cameracoveropenstatus" placeholder="Ϡۺ؇Բߪ"></el-input>
    </el-form-item>
    <el-form-item label="Ϡۺ؇٘ѕ" prop="cameracoverclosestatus">
      <el-input v-model="dataForm.cameracoverclosestatus" placeholder="Ϡۺ؇٘ѕ"></el-input>
    </el-form-item>
    <el-form-item label="նߢ؇Բߪ" prop="toolcoveropenstatus">
      <el-input v-model="dataForm.toolcoveropenstatus" placeholder="նߢ؇Բߪ"></el-input>
    </el-form-item>
    <el-form-item label="նߢ؇٘ѕ" prop="toolcoverclosestatus">
      <el-input v-model="dataForm.toolcoverclosestatus" placeholder="նߢ؇٘ѕ"></el-input>
    </el-form-item>
    <el-form-item label="նߢ̧ɽ؋ɬӶ" prop="toolsopenstatus">
      <el-input v-model="dataForm.toolsopenstatus" placeholder="նߢ̧ɽ؋ɬӶ"></el-input>
    </el-form-item>
    <el-form-item label="նߢ̧ɽ؋˵ۘ" prop="toolsclosestatus">
      <el-input v-model="dataForm.toolsclosestatus" placeholder="նߢ̧ɽ؋˵ۘ"></el-input>
    </el-form-item>
    <el-form-item label="ߗ̽ƸؗɬӶ" prop="holemeaopenstatus">
      <el-input v-model="dataForm.holemeaopenstatus" placeholder="ߗ̽ƸؗɬӶ"></el-input>
    </el-form-item>
    <el-form-item label="ߗ̽Ƹؗ˵ۘ" prop="holemeaclosestatus">
      <el-input v-model="dataForm.holemeaclosestatus" placeholder="ߗ̽Ƹؗ˵ۘ"></el-input>
    </el-form-item>
    <el-form-item label="主轴开" prop="spopenstatus">
      <el-input v-model="dataForm.spopenstatus" placeholder="主轴开"></el-input>
    </el-form-item>
    <el-form-item label="主轴兿" prop="spclosestatus">
      <el-input v-model="dataForm.spclosestatus" placeholder="主轴兿"></el-input>
    </el-form-item>
    <el-form-item label="油雾开关开吿" prop="oilopenstatus">
      <el-input v-model="dataForm.oilopenstatus" placeholder="油雾开关开吿"></el-input>
    </el-form-item>
    <el-form-item label="油雾开关关闿" prop="oilclosestatus">
      <el-input v-model="dataForm.oilclosestatus" placeholder="油雾开关关闿"></el-input>
    </el-form-item>
    <el-form-item label="回刀阀门开" prop="recuropenstatus">
      <el-input v-model="dataForm.recuropenstatus" placeholder="回刀阀门开"></el-input>
    </el-form-item>
    <el-form-item label="回刀阀门关" prop="recurclosestatus">
      <el-input v-model="dataForm.recurclosestatus" placeholder="回刀阀门关"></el-input>
    </el-form-item>
    <el-form-item label="快换法兰开" prop="flangeopenstatus">
      <el-input v-model="dataForm.flangeopenstatus" placeholder="快换法兰开"></el-input>
    </el-form-item>
    <el-form-item label="快换法兰兿" prop="flangeclosestatus">
      <el-input v-model="dataForm.flangeclosestatus" placeholder="快换法兰兿"></el-input>
    </el-form-item>
    <el-form-item label="换刀阀门开" prop="toolchangeropenstatus">
      <el-input v-model="dataForm.toolchangeropenstatus" placeholder="换刀阀门开"></el-input>
    </el-form-item>
    <el-form-item label="换刀阀门关" prop="toolchangerclosestatus">
      <el-input v-model="dataForm.toolchangerclosestatus" placeholder="换刀阀门关"></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          toolstatus: '',
          footopenstatus: '',
          footclosestatus: '',
          cameracoveropenstatus: '',
          cameracoverclosestatus: '',
          toolcoveropenstatus: '',
          toolcoverclosestatus: '',
          toolsopenstatus: '',
          toolsclosestatus: '',
          holemeaopenstatus: '',
          holemeaclosestatus: '',
          spopenstatus: '',
          spclosestatus: '',
          oilopenstatus: '',
          oilclosestatus: '',
          recuropenstatus: '',
          recurclosestatus: '',
          flangeopenstatus: '',
          flangeclosestatus: '',
          toolchangeropenstatus: '',
          toolchangerclosestatus: '',
          time: ''
        },
        dataRule: {
          toolstatus: [
            { required: true, message: 'նޟ״̬不能为空', trigger: 'blur' }
          ],
          footopenstatus: [
            { required: true, message: 'ѹ݅ƸؗɬӶ不能为空', trigger: 'blur' }
          ],
          footclosestatus: [
            { required: true, message: 'ѹ݅Ƹؗ˵ۘ不能为空', trigger: 'blur' }
          ],
          cameracoveropenstatus: [
            { required: true, message: 'Ϡۺ؇Բߪ不能为空', trigger: 'blur' }
          ],
          cameracoverclosestatus: [
            { required: true, message: 'Ϡۺ؇٘ѕ不能为空', trigger: 'blur' }
          ],
          toolcoveropenstatus: [
            { required: true, message: 'նߢ؇Բߪ不能为空', trigger: 'blur' }
          ],
          toolcoverclosestatus: [
            { required: true, message: 'նߢ؇٘ѕ不能为空', trigger: 'blur' }
          ],
          toolsopenstatus: [
            { required: true, message: 'նߢ̧ɽ؋ɬӶ不能为空', trigger: 'blur' }
          ],
          toolsclosestatus: [
            { required: true, message: 'նߢ̧ɽ؋˵ۘ不能为空', trigger: 'blur' }
          ],
          holemeaopenstatus: [
            { required: true, message: 'ߗ̽ƸؗɬӶ不能为空', trigger: 'blur' }
          ],
          holemeaclosestatus: [
            { required: true, message: 'ߗ̽Ƹؗ˵ۘ不能为空', trigger: 'blur' }
          ],
          spopenstatus: [
            { required: true, message: '主轴开不能为空', trigger: 'blur' }
          ],
          spclosestatus: [
            { required: true, message: '主轴兿不能为空', trigger: 'blur' }
          ],
          oilopenstatus: [
            { required: true, message: '油雾开关开吿不能为空', trigger: 'blur' }
          ],
          oilclosestatus: [
            { required: true, message: '油雾开关关闿不能为空', trigger: 'blur' }
          ],
          recuropenstatus: [
            { required: true, message: '回刀阀门开不能为空', trigger: 'blur' }
          ],
          recurclosestatus: [
            { required: true, message: '回刀阀门关不能为空', trigger: 'blur' }
          ],
          flangeopenstatus: [
            { required: true, message: '快换法兰开不能为空', trigger: 'blur' }
          ],
          flangeclosestatus: [
            { required: true, message: '快换法兰兿不能为空', trigger: 'blur' }
          ],
          toolchangeropenstatus: [
            { required: true, message: '换刀阀门开不能为空', trigger: 'blur' }
          ],
          toolchangerclosestatus: [
            { required: true, message: '换刀阀门关不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/statusinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.toolstatus = data.statusinfo.toolstatus
                this.dataForm.footopenstatus = data.statusinfo.footopenstatus
                this.dataForm.footclosestatus = data.statusinfo.footclosestatus
                this.dataForm.cameracoveropenstatus = data.statusinfo.cameracoveropenstatus
                this.dataForm.cameracoverclosestatus = data.statusinfo.cameracoverclosestatus
                this.dataForm.toolcoveropenstatus = data.statusinfo.toolcoveropenstatus
                this.dataForm.toolcoverclosestatus = data.statusinfo.toolcoverclosestatus
                this.dataForm.toolsopenstatus = data.statusinfo.toolsopenstatus
                this.dataForm.toolsclosestatus = data.statusinfo.toolsclosestatus
                this.dataForm.holemeaopenstatus = data.statusinfo.holemeaopenstatus
                this.dataForm.holemeaclosestatus = data.statusinfo.holemeaclosestatus
                this.dataForm.spopenstatus = data.statusinfo.spopenstatus
                this.dataForm.spclosestatus = data.statusinfo.spclosestatus
                this.dataForm.oilopenstatus = data.statusinfo.oilopenstatus
                this.dataForm.oilclosestatus = data.statusinfo.oilclosestatus
                this.dataForm.recuropenstatus = data.statusinfo.recuropenstatus
                this.dataForm.recurclosestatus = data.statusinfo.recurclosestatus
                this.dataForm.flangeopenstatus = data.statusinfo.flangeopenstatus
                this.dataForm.flangeclosestatus = data.statusinfo.flangeclosestatus
                this.dataForm.toolchangeropenstatus = data.statusinfo.toolchangeropenstatus
                this.dataForm.toolchangerclosestatus = data.statusinfo.toolchangerclosestatus
                this.dataForm.time = data.statusinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/statusinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'toolstatus': this.dataForm.toolstatus,
                'footopenstatus': this.dataForm.footopenstatus,
                'footclosestatus': this.dataForm.footclosestatus,
                'cameracoveropenstatus': this.dataForm.cameracoveropenstatus,
                'cameracoverclosestatus': this.dataForm.cameracoverclosestatus,
                'toolcoveropenstatus': this.dataForm.toolcoveropenstatus,
                'toolcoverclosestatus': this.dataForm.toolcoverclosestatus,
                'toolsopenstatus': this.dataForm.toolsopenstatus,
                'toolsclosestatus': this.dataForm.toolsclosestatus,
                'holemeaopenstatus': this.dataForm.holemeaopenstatus,
                'holemeaclosestatus': this.dataForm.holemeaclosestatus,
                'spopenstatus': this.dataForm.spopenstatus,
                'spclosestatus': this.dataForm.spclosestatus,
                'oilopenstatus': this.dataForm.oilopenstatus,
                'oilclosestatus': this.dataForm.oilclosestatus,
                'recuropenstatus': this.dataForm.recuropenstatus,
                'recurclosestatus': this.dataForm.recurclosestatus,
                'flangeopenstatus': this.dataForm.flangeopenstatus,
                'flangeclosestatus': this.dataForm.flangeclosestatus,
                'toolchangeropenstatus': this.dataForm.toolchangeropenstatus,
                'toolchangerclosestatus': this.dataForm.toolchangerclosestatus,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
